package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper;

import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWVideoCompressHelper$doCompress$2", f = "HWVideoCompressHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
public final class HWVideoCompressHelper$doCompress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ BaseApplication $context;
    final /* synthetic */ VideoItem $item;
    int label;
    final /* synthetic */ HWVideoCompressHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWVideoCompressHelper$doCompress$2(VideoItem videoItem, HWVideoCompressHelper hWVideoCompressHelper, BaseApplication baseApplication, Continuation<? super HWVideoCompressHelper$doCompress$2> continuation) {
        super(2, continuation);
        this.$item = videoItem;
        this.this$0 = hWVideoCompressHelper;
        this.$context = baseApplication;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, videoItem, hWVideoCompressHelper, baseApplication, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWVideoCompressHelper$doCompress$2(this.$item, this.this$0, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        HWVideoCompressHelper$createProgressListener$1 e16;
        int d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String localPath = this.$item.getLocalPath();
                boolean z16 = false;
                if (localPath == null) {
                    return Boxing.boxBoolean(false);
                }
                this.$item.setRawSize(new File(localPath).length());
                QLog.i("HW.MediaEdit.HWVideoCompressHelper", 1, "Original video size: " + this.$item.getRawSize() + " bytes");
                VFSFile vFSFile = new VFSFile(TroopHWJsPlugin.L());
                if (!vFSFile.exists()) {
                    vFSFile.mkdirs();
                }
                String outVideoPath = VFSAssistantUtils.getSDKPrivatePath(vFSFile.getAbsolutePath() + "/" + new File(localPath).getName());
                HWVideoCompressHelper hWVideoCompressHelper = this.this$0;
                VideoItem videoItem = this.$item;
                Intrinsics.checkNotNullExpressionValue(outVideoPath, "outVideoPath");
                e16 = hWVideoCompressHelper.e(videoItem, outVideoPath);
                d16 = this.this$0.d(this.$context, localPath, outVideoPath, e16);
                QLog.i("HW.MediaEdit.HWVideoCompressHelper", 1, "Compress fail -> -1, success -> 0, no need -> 1: ret = " + d16);
                if (d16 == 0 || d16 == 1) {
                    z16 = true;
                }
                return Boxing.boxBoolean(z16);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWVideoCompressHelper$doCompress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
