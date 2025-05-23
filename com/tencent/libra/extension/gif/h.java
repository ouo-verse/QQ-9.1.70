package com.tencent.libra.extension.gif;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.base.model.AssetPathModel;
import com.tencent.libra.base.model.Model;
import com.tencent.libra.base.model.UriModel;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h implements r01.a<r01.c> {
    @Override // r01.a
    public boolean a(@NonNull File file) {
        return i.a(file);
    }

    @Override // r01.a
    public boolean b(@NonNull Model<?> model) {
        if (RFWFileUtils.getFileType(model.c()) == FileType.GIF) {
            return true;
        }
        return false;
    }

    @Override // r01.a
    public void c(@NonNull ExtraDecoderRequestInfo extraDecoderRequestInfo, @NonNull Consumer<r01.c> consumer) {
        GifDrawable gifDrawable;
        try {
            Model<?> e16 = extraDecoderRequestInfo.e();
            if (e16 instanceof UriModel) {
                gifDrawable = new GifDrawable(RFWApplication.getApplication().getContentResolver(), (Uri) e16.a(), extraDecoderRequestInfo.getWidth(), extraDecoderRequestInfo.getHeight());
            } else if (e16 instanceof AssetPathModel) {
                gifDrawable = new GifDrawable(new u01.a(((AssetPathModel) e16).a()).a(), extraDecoderRequestInfo.getWidth(), extraDecoderRequestInfo.getHeight());
            } else {
                gifDrawable = new GifDrawable(extraDecoderRequestInfo.getSrcFile(), extraDecoderRequestInfo.getWidth(), extraDecoderRequestInfo.getHeight());
            }
            consumer.accept(gifDrawable);
        } catch (IOException e17) {
            RFWLog.e("LibraGifDecoder", RFWLog.USR, "handleDecode error:" + e17.getMessage(), e17);
            consumer.accept(null);
        }
    }

    @Override // r01.a
    public String getLogTag() {
        return "LibraGifDecoder";
    }
}
