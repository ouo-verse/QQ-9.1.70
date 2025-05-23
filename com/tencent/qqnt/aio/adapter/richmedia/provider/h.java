package com.tencent.qqnt.aio.adapter.richmedia.provider;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'JL\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0016J(\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\bH&\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/richmedia/provider/h;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "subId", "", "Landroid/os/Parcelable;", "c", "type", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "cb", "", "g", "triggerType", "downSourceType", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoCodecFormatType;", "videoCodecFormat", "b", "a", "", "isCompleted", "f", "downType", "e", "Lcom/tencent/mobileqq/data/ChatMessage;", "msg", "Lcom/tencent/mobileqq/app/QBaseActivity;", "topActivity", "d", "curType", "Landroid/content/Intent;", tl.h.F, "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static boolean a(@NotNull h hVar, int i3, int i16) {
            return true;
        }

        public static void b(@NotNull h hVar, @NotNull MsgRecord msgRecord, long j3, int i3, int i16) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            ((IMsgService) QRoute.api(IMsgService.class)).cancelGetRichMediaElement(new RichMediaElementGetReq(msgRecord.msgId, msgRecord.peerUid, msgRecord.chatType, j3, i3, i16, "", 0L, 2, 0));
        }

        public static void c(@NotNull h hVar, @NotNull MsgRecord msgRecord, int i3, int i16, @Nullable MsgElement msgElement, int i17, int i18, @NotNull VideoCodecFormatType videoCodecFormat, @Nullable i iVar) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(videoCodecFormat, "videoCodecFormat");
        }

        public static void d(@NotNull h hVar, @NotNull MsgRecord msgRecord, @NotNull MsgElement element, int i3, int i16) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(element, "element");
            ((IMsgService) QRoute.api(IMsgService.class)).getRichMediaElement(new RichMediaElementGetReq(msgRecord.msgId, msgRecord.peerUid, msgRecord.chatType, element.elementId, i3, i16, "", 0L, 2, 0));
        }

        public static int e(@NotNull h hVar, @NotNull MsgRecord msgRecord, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            return i3;
        }

        public static boolean f(@NotNull h hVar, @NotNull ChatMessage msg2, @NotNull MsgRecord msgRecord, @NotNull QBaseActivity topActivity, @NotNull AppRuntime app) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(topActivity, "topActivity");
            Intrinsics.checkNotNullParameter(app, "app");
            return false;
        }
    }

    void a(@NotNull MsgRecord msgRecord, int subId, int type, @Nullable MsgElement msgElement);

    void b(@NotNull MsgRecord msgRecord, int subId, int type, @Nullable MsgElement msgElement, int triggerType, int downSourceType, @NotNull VideoCodecFormatType videoCodecFormat, @Nullable i cb5);

    @NotNull
    List<Parcelable> c(@NotNull AppRuntime app, @NotNull MsgRecord msgRecord, @Nullable MsgElement msgElement, int subId);

    boolean d(@NotNull ChatMessage msg2, @NotNull MsgRecord msgRecord, @NotNull QBaseActivity topActivity, @NotNull AppRuntime app);

    boolean e(int type, int downType);

    int f(@NotNull MsgRecord msgRecord, int type, boolean isCompleted);

    @Deprecated(message = "\u5e9f\u5f03\u63a5\u53e3\uff0c\u4e0d\u5141\u8bb8\u518d\u4f7f\u7528\uff0c\u540e\u9762\u7528\u4e0b\u9762\u7684download\u66ff\u6362")
    void g(@NotNull MsgRecord msgRecord, int subId, int type, @Nullable MsgElement msgElement, @Nullable i cb5);

    @Nullable
    Intent h(@NotNull MsgRecord msgRecord, int subId, @Nullable MsgElement msgElement, int curType);
}
