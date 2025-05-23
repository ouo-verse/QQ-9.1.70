package com.tencent.libra.decode;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.libra.LoadContext;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.listener.LibraDefaultOnHeaderDecodedListener;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;
import java.io.File;

/* compiled from: P */
@RequiresApi(api = 29)
/* loaded from: classes7.dex */
public class LibraImageDecoderDecodeTask extends LibraBaseBitmapDecodeTask {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraImageDecoderDecodeTask");

    public LibraImageDecoderDecodeTask(LoadContext loadContext, LibraRequestKey libraRequestKey) {
        super(loadContext, libraRequestKey);
    }

    @Override // com.tencent.libra.decode.LibraBaseBitmapDecodeTask
    @Nullable
    protected Bitmap decodeBitmap(Option option) {
        ImageDecoder.Source createSource;
        Bitmap bitmap;
        Model<?> model = option.getModel();
        if (model == null) {
            createSource = ImageDecoder.createSource(new File(option.getLocalPath()));
        } else {
            createSource = model.b();
        }
        try {
            bitmap = ImageDecoder.decodeBitmap(createSource, new LibraDefaultOnHeaderDecodedListener(option));
        } catch (Throwable th5) {
            LibraLogUtil.INSTANCE.e(getLogTag(), RFWLog.USR, option, "[decodeBitmap] throwable:", th5);
            bitmap = null;
        }
        if (needRotateBitmap(option)) {
            return rotateDegree(option, bitmap);
        }
        return bitmap;
    }

    @Override // com.tencent.libra.task.ILibraTask
    public String getLogTag() {
        return TAG;
    }

    public boolean needRotateBitmap(Option option) {
        if (option.getFileType() == FileType.DNG) {
            return true;
        }
        return false;
    }
}
