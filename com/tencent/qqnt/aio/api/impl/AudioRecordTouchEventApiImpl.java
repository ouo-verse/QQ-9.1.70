package com.tencent.qqnt.aio.api.impl;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi;
import com.tencent.qqnt.aio.audiopanel.AudioTouchViewNTProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AudioRecordTouchEventApiImpl;", "Lcom/tencent/qqnt/aio/api/IAudioRecordTouchEventApi;", "Landroid/view/View;", "recordButton", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "setTouchEvent", "destroy", "setPauseEvent", "Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor;", "audioTouchProcessor", "Lcom/tencent/qqnt/aio/audiopanel/AudioTouchViewNTProcessor;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AudioRecordTouchEventApiImpl implements IAudioRecordTouchEventApi {
    private static final a Companion = new a(null);

    @Deprecated
    public static final String TAG = "AudioRecordTouchEventApiImpl";
    private AudioTouchViewNTProcessor audioTouchProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AudioRecordTouchEventApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi
    public void destroy() {
        AudioTouchViewNTProcessor audioTouchViewNTProcessor = this.audioTouchProcessor;
        if (audioTouchViewNTProcessor != null) {
            audioTouchViewNTProcessor.v();
        }
        this.audioTouchProcessor = null;
    }

    @Override // com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi
    public void setPauseEvent() {
        AudioTouchViewNTProcessor audioTouchViewNTProcessor = this.audioTouchProcessor;
        if (audioTouchViewNTProcessor != null) {
            audioTouchViewNTProcessor.E();
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi
    public void setTouchEvent(View recordButton, com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(recordButton, "recordButton");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (!(MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "need QQAppInterface");
        } else {
            this.audioTouchProcessor = new AudioTouchViewNTProcessor(recordButton, aioContext);
        }
    }
}
