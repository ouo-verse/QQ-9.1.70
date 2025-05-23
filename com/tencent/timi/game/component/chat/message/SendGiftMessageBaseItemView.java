package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.utils.IResultListener;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$GiftMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 22\u00020\u0001:\u0003345B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\b\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001f\u001a\u00020\u001eH&J\b\u0010 \u001a\u00020\u001cH&R\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0017R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u00066"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Ltrpc/yes/common/MessageOuterClass$GiftMsg;", "it", "", "Y", "Lnh2/c;", "giftSDK", "", "giftID", "businessId", "Z", "materialID", "a0", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "", "U", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "I", "Lcom/tencent/image/URLImageView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "X", "Landroid/widget/TextView;", "V", "Landroid/view/View;", "W", "T", "f0", "curGiftId", "", "g0", "J", "curRoomId", "h0", "curBusinessId", ExifInterface.LATITUDE_SOUTH, "()Lnh2/c;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i0", "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class SendGiftMessageBaseItemView extends BaseMessageView {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int curGiftId;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private long curRoomId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int curBusinessId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView$b;", "Lrh2/e;", "", "errCode", "", "errMsg", "", "onFailed", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftList", "onReceive", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView;", "d", "Ljava/lang/ref/WeakReference;", "view", "e", "I", "giftID", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements rh2.e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<SendGiftMessageBaseItemView> view;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int giftID;

        public b(@NotNull WeakReference<SendGiftMessageBaseItemView> view, int i3) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.giftID = i3;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @Nullable String errMsg) {
            com.tencent.timi.game.utils.l.e("SendGiftMessageBaseItemView", "getGiftList#onFailed errCode: " + errCode + "; errMsg: " + errMsg);
        }

        @Override // rh2.e
        public void onReceive(@Nullable List<com.tencent.mobileqq.qqgift.data.service.d> giftList) {
            nh2.c S;
            Object obj;
            boolean z16;
            SendGiftMessageBaseItemView sendGiftMessageBaseItemView = this.view.get();
            if (sendGiftMessageBaseItemView == null || (S = sendGiftMessageBaseItemView.S()) == null || this.giftID != sendGiftMessageBaseItemView.curGiftId) {
                return;
            }
            Integer num = null;
            if (giftList != null) {
                Iterator<T> it = giftList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((com.tencent.mobileqq.qqgift.data.service.d) obj).f264874d == this.giftID) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                com.tencent.mobileqq.qqgift.data.service.d dVar = (com.tencent.mobileqq.qqgift.data.service.d) obj;
                if (dVar != null) {
                    num = Integer.valueOf(dVar.C);
                }
            }
            if (num != null) {
                sendGiftMessageBaseItemView.a0(this.giftID, num.intValue(), S);
            } else {
                com.tencent.timi.game.utils.l.e("SendGiftMessageBaseItemView", "materialID is null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView$c;", "Lqh2/f;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView;", "d", "Ljava/lang/ref/WeakReference;", "view", "e", "I", "giftID", "<init>", "(Ljava/lang/ref/WeakReference;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements qh2.f {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<SendGiftMessageBaseItemView> view;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int giftID;

        public c(@NotNull WeakReference<SendGiftMessageBaseItemView> view, int i3) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.giftID = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SendGiftMessageBaseItemView messageBaseItemView, URLDrawable uRLDrawable) {
            Intrinsics.checkNotNullParameter(messageBaseItemView, "$messageBaseItemView");
            messageBaseItemView.R().setImageDrawable(uRLDrawable);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0040 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
        @Override // qh2.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(int id5, @Nullable QQGiftPanelResource panelResource) {
            String str;
            boolean z16;
            boolean isBlank;
            com.tencent.timi.game.utils.l.e("SendGiftMessageBaseItemView", "onLoadSuccess: " + id5);
            final SendGiftMessageBaseItemView sendGiftMessageBaseItemView = this.view.get();
            if (sendGiftMessageBaseItemView == null || sendGiftMessageBaseItemView.curGiftId != this.giftID) {
                return;
            }
            if (panelResource != null) {
                str = panelResource.f265002b;
            } else {
                str = null;
            }
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        return;
                    }
                    final URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, URLDrawable.URLDrawableOptions.obtain());
                    sendGiftMessageBaseItemView.R().post(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.ai
                        @Override // java.lang.Runnable
                        public final void run() {
                            SendGiftMessageBaseItemView.c.b(SendGiftMessageBaseItemView.this, fileDrawable);
                        }
                    });
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e("SendGiftMessageBaseItemView", "errorCode: " + errorCode + "; httpCode: " + httpCode + "; errorMessage: " + errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView$d", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376491a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MessageOuterClass$GiftMsg f376492b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SendGiftMessageBaseItemView f376493c;

        d(CommonOuterClass$QQUserId commonOuterClass$QQUserId, MessageOuterClass$GiftMsg messageOuterClass$GiftMsg, SendGiftMessageBaseItemView sendGiftMessageBaseItemView) {
            this.f376491a = commonOuterClass$QQUserId;
            this.f376492b = messageOuterClass$GiftMsg;
            this.f376493c = sendGiftMessageBaseItemView;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
        
            if (r2 == false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x006a, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
        
            if (r0 != false) goto L25;
         */
        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSuccess(@Nullable IUserInfo userInfo) {
            String str;
            boolean z16;
            PBUInt64Field pBUInt64Field;
            boolean z17;
            PBUInt64Field pBUInt64Field2;
            if (userInfo != null) {
                str = userInfo.i(this.f376491a);
            } else {
                str = null;
            }
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.f376492b.recv_user_id.get();
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "it.recv_user_id.get()");
            CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = commonOuterClass$QQUserId;
            CommonOuterClass$QQUserId selfQQUserId = this.f376493c.getSelfQQUserId();
            boolean z18 = false;
            if (commonOuterClass$QQUserId2.uid.get() != 0) {
                if (selfQQUserId != null && (pBUInt64Field2 = selfQQUserId.uid) != null && commonOuterClass$QQUserId2.uid.get() == pBUInt64Field2.get()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            if (commonOuterClass$QQUserId2.yes_uid.get() != 0) {
                if (selfQQUserId != null && (pBUInt64Field = selfQQUserId.yes_uid) != null && commonOuterClass$QQUserId2.yes_uid.get() == pBUInt64Field.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            if (z18) {
                if (this.f376492b.send_user_id_list.size() > 1) {
                    this.f376493c.T().setText(str + "\u7b49" + this.f376492b.send_user_id_list.size() + "\u4eba\u9001\u7ed9\u4f60");
                } else {
                    this.f376493c.T().setText(str + "\u9001\u7ed9\u4f60");
                }
                this.f376493c.X().setVisibility(8);
                return;
            }
            if (this.f376492b.send_user_id_list.size() > 1) {
                this.f376493c.T().setText(str + "\u7b49" + this.f376492b.send_user_id_list.size() + "\u4eba\u9001\u7ed9");
            } else {
                this.f376493c.T().setText(str + "\u9001\u7ed9");
            }
            this.f376493c.X().setUserId(this.f376492b.recv_user_id);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e("SendGiftMessageBaseItemView", "getUserInfoFromDBOrNet errCode == " + errorCode + ",errMsg == " + errorMessage);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftMessageBaseItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final nh2.c S() {
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(this.curBusinessId);
        if (!sDKImpl.isInited() || sDKImpl.isDestroyed()) {
            return null;
        }
        return sDKImpl;
    }

    private final Map<String, String> U(CommonOuterClass$QQUserId userId) {
        ConcurrentHashMap<String, String> L = YoloRoomUtil.L(getRoomInfo());
        L.put("yes_to_uid", String.valueOf(userId.uid.get()));
        L.put("yes_to_yes_uid", nn4.a.a(userId.yes_uid.get()));
        Intrinsics.checkNotNullExpressionValue(L, "reportParams.apply {\n   \u2026.ulongString())\n        }");
        return L;
    }

    private final void Y(MessageOuterClass$GiftMsg it) {
        CommonOuterClass$QQUserId firstSenderUserId = it.send_user_id_list.get(0);
        bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
        Intrinsics.checkNotNullExpressionValue(firstSenderUserId, "firstSenderUserId");
        dVar.I3(firstSenderUserId, new d(firstSenderUserId, it, this));
    }

    private final void Z(nh2.c giftSDK, int giftID, int businessId) {
        boolean z16;
        Integer num;
        Object obj;
        boolean z17;
        com.tencent.mobileqq.qqgift.data.service.a aVar = new com.tencent.mobileqq.qqgift.data.service.a(1, String.valueOf(businessId), "", "");
        List<com.tencent.mobileqq.qqgift.data.service.d> cacheGiftList = giftSDK.a().t(aVar);
        List<com.tencent.mobileqq.qqgift.data.service.d> list = cacheGiftList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            giftSDK.a().P(aVar, new b(new WeakReference(this), giftID));
            return;
        }
        Intrinsics.checkNotNullExpressionValue(cacheGiftList, "cacheGiftList");
        Iterator<T> it = cacheGiftList.iterator();
        while (true) {
            num = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.qqgift.data.service.d) obj).f264874d == giftID) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.qqgift.data.service.d dVar = (com.tencent.mobileqq.qqgift.data.service.d) obj;
        if (dVar != null) {
            num = Integer.valueOf(dVar.C);
        }
        if (num == null) {
            com.tencent.timi.game.utils.l.e("SendGiftMessageBaseItemView", "materialID is null");
        } else {
            a0(giftID, num.intValue(), giftSDK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(int giftID, int materialID, nh2.c giftSDK) {
        giftSDK.b().e(materialID, new c(new WeakReference(this), giftID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(SendGiftMessageBaseItemView this$0, MessageOuterClass$GiftMsg it, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        n iMessageListener = this$0.getIMessageListener();
        if (iMessageListener != null) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = it.recv_user_id;
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "it.recv_user_id");
            iMessageListener.a(commonOuterClass$QQUserId);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    public void I(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        MessageLayout.a iImConfig = getIImConfig();
        if (iImConfig != null) {
            T().setTextColor(iImConfig.f(msg2));
            X().setTextColor(iImConfig.f(msg2));
            V().setTextColor(iImConfig.a());
        }
        this.curGiftId = 0;
        this.curRoomId = 0L;
        final MessageOuterClass$GiftMsg messageOuterClass$GiftMsg = msg2.a().gift_msg;
        if (messageOuterClass$GiftMsg != null) {
            this.curGiftId = messageOuterClass$GiftMsg.gift_id.get();
            this.curRoomId = messageOuterClass$GiftMsg.room_id.get();
            int f16 = zf4.c.f452468a.f(messageOuterClass$GiftMsg.room_id.get());
            com.tencent.timi.game.initer.impl.b.f377190a.f(f16);
            R().setImageDrawable(null);
            if (messageOuterClass$GiftMsg.send_user_id_list.isEmpty()) {
                X().setUserId(messageOuterClass$GiftMsg.recv_user_id);
            } else {
                Y(messageOuterClass$GiftMsg);
            }
            TextView V = V();
            String c16 = yn4.c.c(R.string.f225096kp);
            Intrinsics.checkNotNullExpressionValue(c16, "getString(R.string.send_gift_to_someone)");
            String format = String.format(c16, Arrays.copyOf(new Object[]{messageOuterClass$GiftMsg.gift_name.get(), Integer.valueOf(messageOuterClass$GiftMsg.total_num.get())}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            V.setText(format);
            W().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SendGiftMessageBaseItemView.b0(SendGiftMessageBaseItemView.this, messageOuterClass$GiftMsg, view);
                }
            });
            R().setImageDrawable(null);
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            View W = W();
            String valueOf = String.valueOf(msg2.id());
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = messageOuterClass$GiftMsg.recv_user_id;
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "it.recv_user_id");
            bVar.a(W, false, valueOf, "em_yes_chat_nickname", U(commonOuterClass$QQUserId));
            this.curBusinessId = f16;
            nh2.c S = S();
            if (S != null) {
                Z(S, this.curGiftId, this.curBusinessId);
            }
        }
    }

    @NotNull
    public abstract URLImageView R();

    @NotNull
    public abstract TextView T();

    @NotNull
    public abstract TextView V();

    @NotNull
    public abstract View W();

    @NotNull
    public abstract AvatarTextView X();

    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    protected boolean z() {
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftMessageBaseItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ SendGiftMessageBaseItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SendGiftMessageBaseItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }
}
