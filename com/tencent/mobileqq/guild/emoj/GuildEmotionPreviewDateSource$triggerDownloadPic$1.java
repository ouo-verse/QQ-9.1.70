package com.tencent.mobileqq.guild.emoj;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.EmotionDownGIFCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class GuildEmotionPreviewDateSource$triggerDownloadPic$1 extends Lambda implements Function1<FileTransNotifyInfo, Unit> {
    final /* synthetic */ MessageForPic $picMessage;
    final /* synthetic */ EmotionDownGIFCallback.a $uiCallback;
    final /* synthetic */ GuildEmotionPreviewDateSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildEmotionPreviewDateSource$triggerDownloadPic$1(GuildEmotionPreviewDateSource guildEmotionPreviewDateSource, MessageForPic messageForPic, EmotionDownGIFCallback.a aVar) {
        super(1);
        this.this$0 = guildEmotionPreviewDateSource;
        this.$picMessage = messageForPic;
        this.$uiCallback = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
        invoke2(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FileTransNotifyInfo it) {
        final boolean s16;
        Handler handler;
        Intrinsics.checkNotNullParameter(it, "it");
        GuildEmotionPreviewDateSource guildEmotionPreviewDateSource = this.this$0;
        String str = it.filePath;
        Intrinsics.checkNotNullExpressionValue(str, "it.filePath");
        s16 = guildEmotionPreviewDateSource.s(str);
        this.$picMessage.path = it.filePath;
        QLog.i("GuildEmotionPreviewDateSource", 1, "download complete isSuccess=" + s16);
        handler = this.this$0.mainThreadHandler;
        final EmotionDownGIFCallback.a aVar = this.$uiCallback;
        final MessageForPic messageForPic = this.$picMessage;
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.emoj.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildEmotionPreviewDateSource$triggerDownloadPic$1.b(EmotionDownGIFCallback.a.this, s16, messageForPic);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EmotionDownGIFCallback.a aVar, boolean z16, MessageForPic messageForPic) {
        if (aVar != null) {
            aVar.d2(z16, messageForPic);
        }
    }
}
