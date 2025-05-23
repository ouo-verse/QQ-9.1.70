package com.tencent.libra.decode;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadContext;
import com.tencent.libra.cache.Key;
import com.tencent.libra.request.ExtraDecoderRequestInfo;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraExtraDecodeTask extends LibraBaseDecodeTask {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraExtraDecodeTask");

    @NonNull
    protected r01.a<?> mTargetDecoder;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Consumer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Option f118642d;

        a(Option option) {
            this.f118642d = option;
        }

        @Override // androidx.core.util.Consumer
        public void accept(Object obj) {
            if (obj == null) {
                LibraLogUtil.INSTANCE.e(LibraExtraDecodeTask.this.getLogTag(), RFWLog.USR, this.f118642d, "[decode] result is null");
            }
            LibraExtraDecodeTask libraExtraDecodeTask = LibraExtraDecodeTask.this;
            libraExtraDecodeTask.mPicLoader.afterDecode(this.f118642d, libraExtraDecodeTask.mTaskStartTime, obj);
        }
    }

    public LibraExtraDecodeTask(LoadContext loadContext, Key key, @NonNull r01.a<?> aVar) {
        super(loadContext, key);
        this.mTargetDecoder = aVar;
    }

    @Override // com.tencent.libra.decode.LibraBaseDecodeTask
    protected void decode(Option option) {
        try {
            this.mTargetDecoder.c(new ExtraDecoderRequestInfo(new File(option.getLocalPath()), option.getModel(), option.getRequestWidth(), option.getRequestHeight(), option.getDecodeFormat(), option.getExtraData(), this.mPicLoader.getBitmapPool(option), option.getSizeFormat()), new a(option));
        } catch (Throwable th5) {
            LibraLogUtil.INSTANCE.e(getLogTag(), RFWLog.USR, option, "[decode] throwable:", th5);
            this.mPicLoader.afterDecode(option, this.mTaskStartTime, null);
        }
    }

    @Override // com.tencent.libra.task.ILibraTask
    public String getLogTag() {
        return TAG + "_" + this.mTargetDecoder.getLogTag();
    }
}
