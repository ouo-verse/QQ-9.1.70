package com.tencent.mobileqq.aio.event;

import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\b\u0016\u0018\u00002\u00020\u0001:\u001e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "AddBotExtData", "AfterSendMsg", "AtMsgSendEvent", "CameraVideoSendEvent", "ChainStickerSendEvent", "EmojiFaceSendEvent", "FileSendEvent", "GetInterceptResendEvent", "InputSendEvent", "MarketFaceSendEvent", "MediaSendEvent", "MsgOnClickRecallMsgsEvent", "MsgOnClickReplyEvent", "MsgOnRevokeEvent", "OnDeleteMsgRecordEvent", "OnMsgSendFailEvent", "OnMsgSendSuccessEvent", "PicEmotionSendEvent", "PttFakeCancelEvent", "PttFakeSendEvent", "PttSendEvent", "RemoveBotExtData", "SendAfterEvent", "SendAlbumMediaEvent", "SendAlbumMixEvent", "SendBeforeEvent", "SendTextWithCallbackData", "SetAIBusinessFlag", "SingleForwardSelectEvent", "TextSendEvent", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class AIOMsgSendEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$AddBotExtData;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "data", "e", "Z", "b", "()Z", "isDisposable", "<init>", "(Ljava/lang/String;Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class AddBotExtData extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isDisposable;

        public AddBotExtData(@NotNull String data, boolean z16) {
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, data, Boolean.valueOf(z16));
            } else {
                this.data = data;
                this.isDisposable = z16;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.data;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isDisposable;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddBotExtData)) {
                return false;
            }
            AddBotExtData addBotExtData = (AddBotExtData) other;
            if (Intrinsics.areEqual(this.data, addBotExtData.data) && this.isDisposable == addBotExtData.isDisposable) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.AddBotExtData";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            int hashCode = this.data.hashCode() * 31;
            boolean z16 = this.isDisposable;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "AddBotExtData(data=" + this.data + ", isDisposable=" + this.isDisposable + ")";
        }

        public /* synthetic */ AddBotExtData(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$AfterSendMsg;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class AfterSendMsg extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AfterSendMsg f188416d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34120);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f188416d = new AfterSendMsg();
            }
        }

        AfterSendMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.AfterSendMsg";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$AtMsgSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "content", "e", "c", "senderUid", "f", AppConstants.Key.COLUMN_MSG_SENDER_UIN, tl.h.F, "b", "senderNick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class AtMsgSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String senderUid;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String senderUin;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String senderNick;

        public AtMsgSendEvent(@NotNull String content, @NotNull String senderUid, @NotNull String senderUin, @NotNull String senderNick) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(senderUid, "senderUid");
            Intrinsics.checkNotNullParameter(senderUin, "senderUin");
            Intrinsics.checkNotNullParameter(senderNick, "senderNick");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, content, senderUid, senderUin, senderNick);
                return;
            }
            this.content = content;
            this.senderUid = senderUid;
            this.senderUin = senderUin;
            this.senderNick = senderNick;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.content;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.senderNick;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.senderUid;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.senderUin;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof AtMsgSendEvent)) {
                return false;
            }
            AtMsgSendEvent atMsgSendEvent = (AtMsgSendEvent) other;
            if (Intrinsics.areEqual(this.content, atMsgSendEvent.content) && Intrinsics.areEqual(this.senderUid, atMsgSendEvent.senderUid) && Intrinsics.areEqual(this.senderUin, atMsgSendEvent.senderUin) && Intrinsics.areEqual(this.senderNick, atMsgSendEvent.senderNick)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.AtMsgSendEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return (((((this.content.hashCode() * 31) + this.senderUid.hashCode()) * 31) + this.senderUin.hashCode()) * 31) + this.senderNick.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "AtMsgSendEvent(content=" + this.content + ", senderUid=" + this.senderUid + ", senderUin=" + this.senderUin + ", senderNick=" + this.senderNick + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$CameraVideoSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "videoPath", "e", "a", "thumbPath", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class CameraVideoSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String videoPath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String thumbPath;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.thumbPath;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.videoPath;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof CameraVideoSendEvent)) {
                return false;
            }
            CameraVideoSendEvent cameraVideoSendEvent = (CameraVideoSendEvent) other;
            if (Intrinsics.areEqual(this.videoPath, cameraVideoSendEvent.videoPath) && Intrinsics.areEqual(this.thumbPath, cameraVideoSendEvent.thumbPath)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.CameraVideoSendEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.videoPath.hashCode() * 31) + this.thumbPath.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "CameraVideoSendEvent(videoPath=" + this.videoPath + ", thumbPath=" + this.thumbPath + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$ChainStickerSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "serverId", "<init>", "(I)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class ChainStickerSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int serverId;

        public ChainStickerSendEvent(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.serverId = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.serverId;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof ChainStickerSendEvent) && this.serverId == ((ChainStickerSendEvent) other).serverId) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.ChainStickerSendEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.serverId;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ChainStickerSendEvent(serverId=" + this.serverId + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$EmojiFaceSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "serverId", "e", "Z", "b", "()Z", "isSingleLottie", "<init>", "(IZ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class EmojiFaceSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int serverId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isSingleLottie;

        public EmojiFaceSendEvent(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                this.serverId = i3;
                this.isSingleLottie = z16;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.serverId;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isSingleLottie;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmojiFaceSendEvent)) {
                return false;
            }
            EmojiFaceSendEvent emojiFaceSendEvent = (EmojiFaceSendEvent) other;
            if (this.serverId == emojiFaceSendEvent.serverId && this.isSingleLottie == emojiFaceSendEvent.isSingleLottie) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.EmojiFaceSendEvent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int i3 = this.serverId * 31;
            boolean z16 = this.isSingleLottie;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "EmojiFaceSendEvent(serverId=" + this.serverId + ", isSingleLottie=" + this.isSingleLottie + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$FileSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "path", "<init>", "(Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class FileSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String path;

        public FileSendEvent(@NotNull String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) path);
            } else {
                this.path = path;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.path;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof FileSendEvent) && Intrinsics.areEqual(this.path, ((FileSendEvent) other).path)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.FileSendEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.path.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "FileSendEvent(path=" + this.path + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$GetInterceptResendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "msgItem", "<init>", "(Lcom/tencent/aio/data/msglist/a;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class GetInterceptResendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.data.msglist.a msgItem;

        public GetInterceptResendEvent(@NotNull com.tencent.aio.data.msglist.a msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            } else {
                this.msgItem = msgItem;
            }
        }

        @NotNull
        public final com.tencent.aio.data.msglist.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof GetInterceptResendEvent) && Intrinsics.areEqual(this.msgItem, ((GetInterceptResendEvent) other).msgItem)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.GetInterceptResendEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "GetInterceptResendEvent(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$InputSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class InputSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final InputSendEvent f188428d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34870);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f188428d = new InputSendEvent();
            }
        }

        InputSendEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.InputSendEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MarketFaceSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "d", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "a", "()Lcom/tencent/mobileqq/data/MarkFaceMessage;", "markFaceMessage", "<init>", "(Lcom/tencent/mobileqq/data/MarkFaceMessage;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class MarketFaceSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarkFaceMessage markFaceMessage;

        public MarketFaceSendEvent(@NotNull MarkFaceMessage markFaceMessage) {
            Intrinsics.checkNotNullParameter(markFaceMessage, "markFaceMessage");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) markFaceMessage);
            } else {
                this.markFaceMessage = markFaceMessage;
            }
        }

        @NotNull
        public final MarkFaceMessage a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MarkFaceMessage) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.markFaceMessage;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof MarketFaceSendEvent) && Intrinsics.areEqual(this.markFaceMessage, ((MarketFaceSendEvent) other).markFaceMessage)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MarketFaceSendEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.markFaceMessage.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "MarketFaceSendEvent(markFaceMessage=" + this.markFaceMessage + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\f\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MediaSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/album/media/c;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "mediaList", "e", "Z", "()Z", CustomImageProps.QUALITY, "f", "c", "needInputText", tl.h.F, "a", "fromCamera", "<init>", "(Ljava/util/List;ZZZ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class MediaSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.mobileqq.album.media.c> mediaList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean needInputText;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean fromCamera;

        public /* synthetic */ MediaSendEvent(List list, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z16, (i3 & 4) != 0 ? true : z17, (i3 & 8) != 0 ? false : z18);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3), defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.fromCamera;
        }

        @NotNull
        public final List<com.tencent.mobileqq.album.media.c> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mediaList;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.needInputText;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.quality;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaSendEvent)) {
                return false;
            }
            MediaSendEvent mediaSendEvent = (MediaSendEvent) other;
            if (Intrinsics.areEqual(this.mediaList, mediaSendEvent.mediaList) && this.quality == mediaSendEvent.quality && this.needInputText == mediaSendEvent.needInputText && this.fromCamera == mediaSendEvent.fromCamera) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MediaSendEvent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            int hashCode = this.mediaList.hashCode() * 31;
            boolean z16 = this.quality;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.needInputText;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            boolean z18 = this.fromCamera;
            if (!z18) {
                i3 = z18 ? 1 : 0;
            }
            return i19 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "MediaSendEvent(mediaList=" + this.mediaList + ", quality=" + this.quality + ", needInputText=" + this.needInputText + ", fromCamera=" + this.fromCamera + ")";
        }

        public MediaSendEvent(@NotNull List<com.tencent.mobileqq.album.media.c> mediaList, boolean z16, boolean z17, boolean z18) {
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, mediaList, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
                return;
            }
            this.mediaList = mediaList;
            this.quality = z16;
            this.needInputText = z17;
            this.fromCamera = z18;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnClickRecallMsgsEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgItem", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class MsgOnClickRecallMsgsEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MsgRecord msgItem;

        public MsgOnClickRecallMsgsEvent(@NotNull MsgRecord msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            } else {
                this.msgItem = msgItem;
            }
        }

        @NotNull
        public final MsgRecord a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof MsgOnClickRecallMsgsEvent) && Intrinsics.areEqual(this.msgItem, ((MsgOnClickRecallMsgsEvent) other).msgItem)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnClickRecallMsgsEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "MsgOnClickRecallMsgsEvent(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnClickReplyEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "c", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "e", "I", "a", "()I", "from", "f", "Z", "b", "()Z", "invokeKeyboard", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;IZ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class MsgOnClickReplyEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int from;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean invokeKeyboard;

        public /* synthetic */ MsgOnClickReplyEvent(AIOMsgItem aIOMsgItem, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIOMsgItem, i3, (i16 & 4) != 0 ? true : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIOMsgItem, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.from;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.invokeKeyboard;
        }

        @NotNull
        public final AIOMsgItem c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgOnClickReplyEvent)) {
                return false;
            }
            MsgOnClickReplyEvent msgOnClickReplyEvent = (MsgOnClickReplyEvent) other;
            if (Intrinsics.areEqual(this.msgItem, msgOnClickReplyEvent.msgItem) && this.from == msgOnClickReplyEvent.from && this.invokeKeyboard == msgOnClickReplyEvent.invokeKeyboard) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnClickReplyEvent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            int hashCode = ((this.msgItem.hashCode() * 31) + this.from) * 31;
            boolean z16 = this.invokeKeyboard;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "MsgOnClickReplyEvent(msgItem=" + this.msgItem + ", from=" + this.from + ", invokeKeyboard=" + this.invokeKeyboard + ")";
        }

        public MsgOnClickReplyEvent(@NotNull AIOMsgItem msgItem, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, msgItem, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.msgItem = msgItem;
            this.from = i3;
            this.invokeKeyboard = z16;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnRevokeEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "b", "()J", "msgSeq", "e", "a", "msgId", "<init>", "(JJ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class MsgOnRevokeEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long msgSeq;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        public MsgOnRevokeEvent(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.msgSeq = j3;
                this.msgId = j16;
            }
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.msgId;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.msgSeq;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof MsgOnRevokeEvent)) {
                return false;
            }
            MsgOnRevokeEvent msgOnRevokeEvent = (MsgOnRevokeEvent) other;
            if (this.msgSeq == msgOnRevokeEvent.msgSeq && this.msgId == msgOnRevokeEvent.msgId) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnRevokeEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (androidx.fragment.app.a.a(this.msgSeq) * 31) + androidx.fragment.app.a.a(this.msgId);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "MsgOnRevokeEvent(msgSeq=" + this.msgSeq + ", msgId=" + this.msgId + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$OnDeleteMsgRecordEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class OnDeleteMsgRecordEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        public OnDeleteMsgRecordEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnDeleteMsgRecordEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$OnMsgSendFailEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "result", "e", "Ljava/lang/String;", "getErrMsg", "()Ljava/lang/String;", "errMsg", "<init>", "(ILjava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class OnMsgSendFailEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int result;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String errMsg;

        public OnMsgSendFailEvent(int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            } else {
                this.result = i3;
                this.errMsg = str;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.result;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnMsgSendFailEvent)) {
                return false;
            }
            OnMsgSendFailEvent onMsgSendFailEvent = (OnMsgSendFailEvent) other;
            if (this.result == onMsgSendFailEvent.result && Intrinsics.areEqual(this.errMsg, onMsgSendFailEvent.errMsg)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendFailEvent";
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int i3 = this.result * 31;
            String str = this.errMsg;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "OnMsgSendFailEvent(result=" + this.result + ", errMsg=" + this.errMsg + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$OnMsgSendSuccessEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "b", "()J", "msgId", "Lcom/tencent/aio/msgservice/k;", "e", "Lcom/tencent/aio/msgservice/k;", "c", "()Lcom/tencent/aio/msgservice/k;", "sendReq", "", "f", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "inputText", "Landroid/os/Bundle;", tl.h.F, "Landroid/os/Bundle;", "getExtData", "()Landroid/os/Bundle;", "extData", "<init>", "(JLcom/tencent/aio/msgservice/k;Ljava/lang/CharSequence;Landroid/os/Bundle;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class OnMsgSendSuccessEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.msgservice.k sendReq;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final CharSequence inputText;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Bundle extData;

        public OnMsgSendSuccessEvent(long j3, @NotNull com.tencent.aio.msgservice.k sendReq, @Nullable CharSequence charSequence, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(sendReq, "sendReq");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), sendReq, charSequence, bundle);
                return;
            }
            this.msgId = j3;
            this.sendReq = sendReq;
            this.inputText = charSequence;
            this.extData = bundle;
        }

        @Nullable
        public final CharSequence a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.inputText;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.msgId;
        }

        @NotNull
        public final com.tencent.aio.msgservice.k c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.aio.msgservice.k) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.sendReq;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnMsgSendSuccessEvent)) {
                return false;
            }
            OnMsgSendSuccessEvent onMsgSendSuccessEvent = (OnMsgSendSuccessEvent) other;
            if (this.msgId == onMsgSendSuccessEvent.msgId && Intrinsics.areEqual(this.sendReq, onMsgSendSuccessEvent.sendReq) && Intrinsics.areEqual(this.inputText, onMsgSendSuccessEvent.inputText) && Intrinsics.areEqual(this.extData, onMsgSendSuccessEvent.extData)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendSuccessEvent";
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            int a16 = ((androidx.fragment.app.a.a(this.msgId) * 31) + this.sendReq.hashCode()) * 31;
            CharSequence charSequence = this.inputText;
            int i3 = 0;
            if (charSequence == null) {
                hashCode = 0;
            } else {
                hashCode = charSequence.hashCode();
            }
            int i16 = (a16 + hashCode) * 31;
            Bundle bundle = this.extData;
            if (bundle != null) {
                i3 = bundle.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            long j3 = this.msgId;
            com.tencent.aio.msgservice.k kVar = this.sendReq;
            CharSequence charSequence = this.inputText;
            return "OnMsgSendSuccessEvent(msgId=" + j3 + ", sendReq=" + kVar + ", inputText=" + ((Object) charSequence) + ", extData=" + this.extData + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PicEmotionSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "path", "e", "I", "()I", QCircleLpReportDc010001.KEY_SUBTYPE, "f", "textSummary", "Lcom/tencent/qqnt/msg/data/g;", tl.h.F, "Lcom/tencent/qqnt/msg/data/g;", "c", "()Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "i", "a", "originalMd5", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/qqnt/msg/data/g;Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class PicEmotionSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int subType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String textSummary;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.qqnt.msg.data.g picExtBizInfo;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String originalMd5;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public PicEmotionSendEvent(@NotNull String path, int i3, @Nullable String str, @Nullable com.tencent.qqnt.msg.data.g gVar) {
            this(path, i3, str, gVar, null, 16, null);
            Intrinsics.checkNotNullParameter(path, "path");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                return;
            }
            iPatchRedirector.redirect((short) 17, this, path, Integer.valueOf(i3), str, gVar);
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.originalMd5;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.path;
        }

        @Nullable
        public final com.tencent.qqnt.msg.data.g c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.qqnt.msg.data.g) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.picExtBizInfo;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.subType;
        }

        @Nullable
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.textSummary;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof PicEmotionSendEvent)) {
                return false;
            }
            PicEmotionSendEvent picEmotionSendEvent = (PicEmotionSendEvent) other;
            if (Intrinsics.areEqual(this.path, picEmotionSendEvent.path) && this.subType == picEmotionSendEvent.subType && Intrinsics.areEqual(this.textSummary, picEmotionSendEvent.textSummary) && Intrinsics.areEqual(this.picExtBizInfo, picEmotionSendEvent.picExtBizInfo) && Intrinsics.areEqual(this.originalMd5, picEmotionSendEvent.originalMd5)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PicEmotionSendEvent";
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            int hashCode3 = ((this.path.hashCode() * 31) + this.subType) * 31;
            String str = this.textSummary;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            com.tencent.qqnt.msg.data.g gVar = this.picExtBizInfo;
            if (gVar == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = gVar.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.originalMd5;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "PicEmotionSendEvent(path=" + this.path + ", subType=" + this.subType + ", textSummary=" + this.textSummary + ", picExtBizInfo=" + this.picExtBizInfo + ", originalMd5=" + this.originalMd5 + ")";
        }

        public /* synthetic */ PicEmotionSendEvent(String str, int i3, String str2, com.tencent.qqnt.msg.data.g gVar, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : gVar, (i16 & 16) != 0 ? null : str3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, gVar, str3, Integer.valueOf(i16), defaultConstructorMarker);
        }

        @JvmOverloads
        public PicEmotionSendEvent(@NotNull String path, int i3, @Nullable String str, @Nullable com.tencent.qqnt.msg.data.g gVar, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(path, "path");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, path, Integer.valueOf(i3), str, gVar, str2);
                return;
            }
            this.path = path;
            this.subType = i3;
            this.textSummary = str;
            this.picExtBizInfo = gVar;
            this.originalMd5 = str2;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttFakeCancelEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "msgId", "<init>", "(J)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class PttFakeCancelEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        public PttFakeCancelEvent(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
            } else {
                this.msgId = j3;
            }
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.msgId;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof PttFakeCancelEvent) && this.msgId == ((PttFakeCancelEvent) other).msgId) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PttFakeCancelEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return androidx.fragment.app.a.a(this.msgId);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "PttFakeCancelEvent(msgId=" + this.msgId + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\b\b\u0002\u0010'\u001a\u00020\b\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020*\u00a2\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R'\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#R\u0017\u0010'\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010#R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b\n\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttFakeSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "path", "", UserInfo.SEX_FEMALE, "c", "()F", "duration", "f", "I", "b", "()I", "audioType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "audioData", "i", "Z", "()Z", "isVoiceChange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "isAutoConvertText", BdhLogUtil.LogTag.Tag_Conn, "voiceChangeType", "", "D", "J", "()J", "msgId", "<init>", "(Ljava/lang/String;FILjava/util/ArrayList;ZZIJ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class PttFakeSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private final int voiceChangeType;

        /* renamed from: D, reason: from kotlin metadata */
        private final long msgId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float duration;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int audioType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Byte> audioData;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean isVoiceChange;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final boolean isAutoConvertText;

        public PttFakeSendEvent(@NotNull String path, float f16, int i3, @NotNull ArrayList<Byte> audioData, boolean z16, boolean z17, int i16, long j3) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(audioData, "audioData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, path, Float.valueOf(f16), Integer.valueOf(i3), audioData, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), Long.valueOf(j3));
                return;
            }
            this.path = path;
            this.duration = f16;
            this.audioType = i3;
            this.audioData = audioData;
            this.isVoiceChange = z16;
            this.isAutoConvertText = z17;
            this.voiceChangeType = i16;
            this.msgId = j3;
        }

        @NotNull
        public final ArrayList<Byte> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.audioData;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.audioType;
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.duration;
        }

        public final long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
            }
            return this.msgId;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.path;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof PttFakeSendEvent)) {
                return false;
            }
            PttFakeSendEvent pttFakeSendEvent = (PttFakeSendEvent) other;
            if (Intrinsics.areEqual(this.path, pttFakeSendEvent.path) && Float.compare(this.duration, pttFakeSendEvent.duration) == 0 && this.audioType == pttFakeSendEvent.audioType && Intrinsics.areEqual(this.audioData, pttFakeSendEvent.audioData) && this.isVoiceChange == pttFakeSendEvent.isVoiceChange && this.isAutoConvertText == pttFakeSendEvent.isAutoConvertText && this.voiceChangeType == pttFakeSendEvent.voiceChangeType && this.msgId == pttFakeSendEvent.msgId) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (String) iPatchRedirector.redirect((short) 23, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PttFakeSendEvent";
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.voiceChangeType;
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.isAutoConvertText;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isVoiceChange;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
            }
            int hashCode = ((((((this.path.hashCode() * 31) + Float.floatToIntBits(this.duration)) * 31) + this.audioType) * 31) + this.audioData.hashCode()) * 31;
            boolean z16 = this.isVoiceChange;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isAutoConvertText;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((((i17 + i3) * 31) + this.voiceChangeType) * 31) + androidx.fragment.app.a.a(this.msgId);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return "PttFakeSendEvent(path=" + this.path + ", duration=" + this.duration + ", audioType=" + this.audioType + ", audioData=" + this.audioData + ", isVoiceChange=" + this.isVoiceChange + ", isAutoConvertText=" + this.isAutoConvertText + ", voiceChangeType=" + this.voiceChangeType + ", msgId=" + this.msgId + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\b\b\u0002\u0010'\u001a\u00020\b\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R'\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#R\u0017\u0010'\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010#R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R$\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b\n\u0010-\"\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$PttSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "path", "", UserInfo.SEX_FEMALE, "c", "()F", "duration", "f", "I", "b", "()I", "audioType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "audioData", "i", "Z", "()Z", "isVoiceChange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "isAutoConvertText", BdhLogUtil.LogTag.Tag_Conn, "voiceChangeType", "", "D", "Ljava/lang/Long;", "()Ljava/lang/Long;", "setMsgId", "(Ljava/lang/Long;)V", "msgId", "<init>", "(Ljava/lang/String;FILjava/util/ArrayList;ZZILjava/lang/Long;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class PttSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private final int voiceChangeType;

        /* renamed from: D, reason: from kotlin metadata */
        @Nullable
        private Long msgId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float duration;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int audioType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Byte> audioData;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean isVoiceChange;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final boolean isAutoConvertText;

        public PttSendEvent(@NotNull String path, float f16, int i3, @NotNull ArrayList<Byte> audioData, boolean z16, boolean z17, int i16, @Nullable Long l3) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(audioData, "audioData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, path, Float.valueOf(f16), Integer.valueOf(i3), audioData, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), l3);
                return;
            }
            this.path = path;
            this.duration = f16;
            this.audioType = i3;
            this.audioData = audioData;
            this.isVoiceChange = z16;
            this.isAutoConvertText = z17;
            this.voiceChangeType = i16;
            this.msgId = l3;
        }

        @NotNull
        public final ArrayList<Byte> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.audioData;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.audioType;
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.duration;
        }

        @Nullable
        public final Long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Long) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.msgId;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.path;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof PttSendEvent)) {
                return false;
            }
            PttSendEvent pttSendEvent = (PttSendEvent) other;
            if (Intrinsics.areEqual(this.path, pttSendEvent.path) && Float.compare(this.duration, pttSendEvent.duration) == 0 && this.audioType == pttSendEvent.audioType && Intrinsics.areEqual(this.audioData, pttSendEvent.audioData) && this.isVoiceChange == pttSendEvent.isVoiceChange && this.isAutoConvertText == pttSendEvent.isAutoConvertText && this.voiceChangeType == pttSendEvent.voiceChangeType && Intrinsics.areEqual(this.msgId, pttSendEvent.msgId)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (String) iPatchRedirector.redirect((short) 24, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.PttSendEvent";
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.voiceChangeType;
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.isAutoConvertText;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isVoiceChange;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
            }
            int hashCode2 = ((((((this.path.hashCode() * 31) + Float.floatToIntBits(this.duration)) * 31) + this.audioType) * 31) + this.audioData.hashCode()) * 31;
            boolean z16 = this.isVoiceChange;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode2 + i16) * 31;
            boolean z17 = this.isAutoConvertText;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int i18 = (((i17 + i3) * 31) + this.voiceChangeType) * 31;
            Long l3 = this.msgId;
            if (l3 == null) {
                hashCode = 0;
            } else {
                hashCode = l3.hashCode();
            }
            return i18 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (String) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            return "PttSendEvent(path=" + this.path + ", duration=" + this.duration + ", audioType=" + this.audioType + ", audioData=" + this.audioData + ", isVoiceChange=" + this.isVoiceChange + ", isAutoConvertText=" + this.isAutoConvertText + ", voiceChangeType=" + this.voiceChangeType + ", msgId=" + this.msgId + ")";
        }

        public /* synthetic */ PttSendEvent(String str, float f16, int i3, ArrayList arrayList, boolean z16, boolean z17, int i16, Long l3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f16, i3, arrayList, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? false : z17, (i17 & 64) != 0 ? 0 : i16, (i17 & 128) != 0 ? null : l3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Float.valueOf(f16), Integer.valueOf(i3), arrayList, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), l3, Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$RemoveBotExtData;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "data", "<init>", "(Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class RemoveBotExtData extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String data;

        public RemoveBotExtData(@NotNull String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) data);
            } else {
                this.data = data;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof RemoveBotExtData) && Intrinsics.areEqual(this.data, ((RemoveBotExtData) other).data)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.RemoveBotExtData";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "RemoveBotExtData(data=" + this.data + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SendAfterEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/lang/CharSequence;", "getCharSequence", "()Ljava/lang/CharSequence;", "charSequence", "<init>", "(Ljava/lang/CharSequence;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SendAfterEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence charSequence;

        public SendAfterEvent(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) charSequence);
            } else {
                this.charSequence = charSequence;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SendAfterEvent) && Intrinsics.areEqual(this.charSequence, ((SendAfterEvent) other).charSequence)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendAfterEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.charSequence.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SendAfterEvent(charSequence=" + ((Object) this.charSequence) + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SendAlbumMediaEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/album/media/c;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "data", "e", "Z", "b", "()Z", CustomImageProps.QUALITY, "f", "c", "isFlashPic", "<init>", "(Ljava/util/List;ZZ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SendAlbumMediaEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.mobileqq.album.media.c> data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isFlashPic;

        public /* synthetic */ SendAlbumMediaEvent(List list, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z16, (i3 & 4) != 0 ? false : z17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
        }

        @NotNull
        public final List<com.tencent.mobileqq.album.media.c> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.data;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.quality;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isFlashPic;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendAlbumMediaEvent)) {
                return false;
            }
            SendAlbumMediaEvent sendAlbumMediaEvent = (SendAlbumMediaEvent) other;
            if (Intrinsics.areEqual(this.data, sendAlbumMediaEvent.data) && this.quality == sendAlbumMediaEvent.quality && this.isFlashPic == sendAlbumMediaEvent.isFlashPic) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendAlbumMediaEvent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            int hashCode = this.data.hashCode() * 31;
            boolean z16 = this.quality;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isFlashPic;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "SendAlbumMediaEvent(data=" + this.data + ", quality=" + this.quality + ", isFlashPic=" + this.isFlashPic + ")";
        }

        public SendAlbumMediaEvent(@NotNull List<com.tencent.mobileqq.album.media.c> data, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(data, "data");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, data, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            this.data = data;
            this.quality = z16;
            this.isFlashPic = z17;
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SendAlbumMixEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/album/media/c;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "data", "e", "Z", "b", "()Z", CustomImageProps.QUALITY, "f", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "<init>", "(Ljava/util/List;ZLjava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SendAlbumMixEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<com.tencent.mobileqq.album.media.c> data;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        public SendAlbumMixEvent(@NotNull List<com.tencent.mobileqq.album.media.c> data, boolean z16, @NotNull String text) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, data, Boolean.valueOf(z16), text);
                return;
            }
            this.data = data;
            this.quality = z16;
            this.text = text;
        }

        @NotNull
        public final List<com.tencent.mobileqq.album.media.c> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.data;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.quality;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendAlbumMixEvent)) {
                return false;
            }
            SendAlbumMixEvent sendAlbumMixEvent = (SendAlbumMixEvent) other;
            if (Intrinsics.areEqual(this.data, sendAlbumMixEvent.data) && this.quality == sendAlbumMixEvent.quality && Intrinsics.areEqual(this.text, sendAlbumMixEvent.text)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendAlbumMixEvent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int hashCode = this.data.hashCode() * 31;
            boolean z16 = this.quality;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.text.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "SendAlbumMixEvent(data=" + this.data + ", quality=" + this.quality + ", text=" + this.text + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SendBeforeEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class SendBeforeEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final SendBeforeEvent f188472d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37059);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f188472d = new SendBeforeEvent();
            }
        }

        SendBeforeEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendBeforeEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SendTextWithCallbackData;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "e", "a", "callbackData", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SendTextWithCallbackData extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String callbackData;

        public SendTextWithCallbackData(@NotNull String text, @NotNull String callbackData) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(callbackData, "callbackData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) text, (Object) callbackData);
            } else {
                this.text = text;
                this.callbackData = callbackData;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.callbackData;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendTextWithCallbackData)) {
                return false;
            }
            SendTextWithCallbackData sendTextWithCallbackData = (SendTextWithCallbackData) other;
            if (Intrinsics.areEqual(this.text, sendTextWithCallbackData.text) && Intrinsics.areEqual(this.callbackData, sendTextWithCallbackData.callbackData)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SendTextWithCallbackData";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.text.hashCode() * 31) + this.callbackData.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "SendTextWithCallbackData(text=" + this.text + ", callbackData=" + this.callbackData + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SetAIBusinessFlag;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "type", "<init>", "(I)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SetAIBusinessFlag extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        public SetAIBusinessFlag(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.type = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SetAIBusinessFlag) && this.type == ((SetAIBusinessFlag) other).type) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SetAIBusinessFlag";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.type;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SetAIBusinessFlag(type=" + this.type + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$SingleForwardSelectEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class SingleForwardSelectEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        public SingleForwardSelectEvent(@NotNull AIOMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            } else {
                this.msgItem = msgItem;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof SingleForwardSelectEvent) && Intrinsics.areEqual(this.msgItem, ((SingleForwardSelectEvent) other).msgItem)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.SingleForwardSelectEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.msgItem.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SingleForwardSelectEvent(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$TextSendEvent;", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class TextSendEvent extends AIOMsgSendEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String text;

        public TextSendEvent(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) text);
            } else {
                this.text = text;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof TextSendEvent) && Intrinsics.areEqual(this.text, ((TextSendEvent) other).text)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.mobileqq.aio.event.AIOMsgSendEvent.TextSendEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.text.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "TextSendEvent(text=" + this.text + ")";
        }
    }

    public AIOMsgSendEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }
}
