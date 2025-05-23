package com.tencent.mobileqq.aio.msglist.holder.component.avatar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.avatar.AIOAvatarUIState;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.widget.AvatarContainer;
import com.tencent.mobileqq.aio.widget.CommonImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOAvatarApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.IAvatarOutboundApi;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.avatar.i;
import com.tencent.qqnt.avatar.j;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0007OPQR8<SB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u0014\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001a\u0010!\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J&\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020&H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0010\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u000200H\u0016J\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020003H\u0016J\u0012\u00107\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/qqnt/avatar/d;", "", "r1", "E1", "", "J1", "v1", "L1", "isMosaic", "C1", "", "visibility", "K1", "", "", "payloads", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", Constants.BASE_IN_PLUGIN_ID, "isCallLoadAvatar", "I1", "Landroid/content/Context;", "context", "H1", Constants.APK_CERTIFICATE, "Landroid/graphics/drawable/Drawable;", "A1", "", "msgId", "B1", "drawable", "x1", "F1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "Landroid/view/View;", "view", "m1", "importance", "l1", "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "e1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "d1", "result", DomainData.DOMAIN_NAME, "e", "Z", "isTempChat", "Lcom/tencent/mobileqq/aio/widget/CommonImageView;", "f", "Lkotlin/Lazy;", "z1", "()Lcom/tencent/mobileqq/aio/widget/CommonImageView;", "avatarView", "Lcom/tencent/mobileqq/aio/widget/AvatarContainer;", h.F, "y1", "()Lcom/tencent/mobileqq/aio/widget/AvatarContainer;", "avatarContainer", "i", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Object;", "avatarDrawable", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "d", "g", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes11.dex */
public final class AIOAvatarContentComponent extends com.tencent.mobileqq.aio.msglist.holder.component.c implements com.tencent.qqnt.avatar.d {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isTempChat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AIOMsgItem aioMsgItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object avatarDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$a;", "Lcom/tencent/qqnt/aio/holder/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class a implements com.tencent.qqnt.aio.holder.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        public a(@NotNull AIOMsgItem msgItem) {
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
            if ((other instanceof a) && Intrinsics.areEqual(this.msgItem, ((a) other).msgItem)) {
                return true;
            }
            return false;
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
            return "AIOBubbleAvatarLongClickIntent(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$b;", "Lcom/tencent/qqnt/aio/holder/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class b implements com.tencent.qqnt.aio.holder.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        public b(@NotNull AIOMsgItem msgItem) {
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
            if ((other instanceof b) && Intrinsics.areEqual(this.msgItem, ((b) other).msgItem)) {
                return true;
            }
            return false;
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
            return "AvatarClickIntent(msgItem=" + this.msgItem + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$c;", "Lcom/tencent/qqnt/aio/holder/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "b", "(Z)V", "isMosaic", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class c implements com.tencent.qqnt.aio.holder.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isMosaic;

        public c() {
            this(false, 1, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isMosaic;
        }

        public final void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.isMosaic = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof c) && this.isMosaic == ((c) other).isMosaic) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            boolean z16 = this.isMosaic;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "AvatarGetMosaicStatus(isMosaic=" + this.isMosaic + ")";
        }

        public c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.isMosaic = z16;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            }
        }

        public /* synthetic */ c(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$d;", "Lcom/tencent/qqnt/aio/holder/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "nickName", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class d implements com.tencent.qqnt.aio.holder.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String nickName;

        public d(@NotNull AIOMsgItem msgItem, @NotNull String nickName) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem, (Object) nickName);
            } else {
                this.msgItem = msgItem;
                this.nickName = nickName;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.nickName;
        }

        public final void c(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.nickName = str;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            if (Intrinsics.areEqual(this.msgItem, dVar.msgItem) && Intrinsics.areEqual(this.nickName, dVar.nickName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (this.msgItem.hashCode() * 31) + this.nickName.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "AvatarGetNickNameIntent(msgItem=" + this.msgItem + ", nickName=" + this.nickName + ")";
        }

        public /* synthetic */ d(AIOMsgItem aIOMsgItem, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIOMsgItem, (i3 & 2) != 0 ? "" : str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIOMsgItem, str, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$e;", "Lcom/tencent/qqnt/aio/holder/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "e", "Z", "b", "()Z", "c", "(Z)V", "isHide", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class e implements com.tencent.qqnt.aio.holder.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isHide;

        public e(@NotNull AIOMsgItem msgItem, boolean z16) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, msgItem, Boolean.valueOf(z16));
            } else {
                this.msgItem = msgItem;
                this.isHide = z16;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isHide;
        }

        public final void c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.isHide = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof e)) {
                return false;
            }
            e eVar = (e) other;
            if (Intrinsics.areEqual(this.msgItem, eVar.msgItem) && this.isHide == eVar.isHide) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int hashCode = this.msgItem.hashCode() * 31;
            boolean z16 = this.isHide;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "AvatarIsNeedHide(msgItem=" + this.msgItem + ", isHide=" + this.isHide + ")";
        }

        public /* synthetic */ e(AIOMsgItem aIOMsgItem, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIOMsgItem, (i3 & 2) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIOMsgItem, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$f;", "Lcom/tencent/qqnt/aio/holder/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "e", "Z", "b", "()Z", "c", "(Z)V", "isTempChat", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class f implements com.tencent.qqnt.aio.holder.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOMsgItem msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isTempChat;

        public f(@NotNull AIOMsgItem msgItem, boolean z16) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, msgItem, Boolean.valueOf(z16));
            } else {
                this.msgItem = msgItem;
                this.isTempChat = z16;
            }
        }

        @NotNull
        public final AIOMsgItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.msgItem;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isTempChat;
        }

        public final void c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.isTempChat = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof f)) {
                return false;
            }
            f fVar = (f) other;
            if (Intrinsics.areEqual(this.msgItem, fVar.msgItem) && this.isTempChat == fVar.isTempChat) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            int hashCode = this.msgItem.hashCode() * 31;
            boolean z16 = this.isTempChat;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "AvatarIsTempChat(msgItem=" + this.msgItem + ", isTempChat=" + this.isTempChat + ")";
        }

        public /* synthetic */ f(AIOMsgItem aIOMsgItem, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIOMsgItem, (i3 & 2) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIOMsgItem, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/avatar/AIOAvatarContentComponent$g;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.avatar.AIOAvatarContentComponent$g, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60125);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOAvatarContentComponent(@NotNull final Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<CommonImageView>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.avatar.AIOAvatarContentComponent$avatarView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final CommonImageView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (CommonImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    CommonImageView commonImageView = new CommonImageView(this.$context, null, 0);
                    Context context2 = this.$context;
                    commonImageView.setId(R.id.f164095sh0);
                    int dimension = (int) commonImageView.getResources().getDimension(R.dimen.f158194bz1);
                    commonImageView.setLayoutParams(new ViewGroup.MarginLayoutParams(dimension, dimension));
                    commonImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (((IAIOAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOAvatarApi.class)).useCircleImageView()) {
                        commonImageView.setCornerRadiusAndMode(ViewUtils.dip2px(20.0f), 1);
                    }
                    commonImageView.setImageDrawable(ResourcesCompat.getDrawable(context2.getResources(), R.drawable.f160830com, context2.getTheme()));
                    commonImageView.setZ(0.0f);
                    return commonImageView;
                }
            });
            this.avatarView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AvatarContainer>(context, this) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.avatar.AIOAvatarContentComponent$avatarContainer$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;
                final /* synthetic */ AIOAvatarContentComponent this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AvatarContainer invoke() {
                    CommonImageView z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AvatarContainer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AvatarContainer avatarContainer = new AvatarContainer(this.$context);
                    AIOAvatarContentComponent aIOAvatarContentComponent = this.this$0;
                    avatarContainer.setId(R.id.sgy);
                    int dimension = (int) avatarContainer.getResources().getDimension(R.dimen.f158194bz1);
                    avatarContainer.setClipChildren(false);
                    avatarContainer.setClipToPadding(false);
                    avatarContainer.setLayoutParams(new ViewGroup.MarginLayoutParams(dimension, dimension));
                    z16 = aIOAvatarContentComponent.z1();
                    avatarContainer.addView(z16);
                    avatarContainer.setImportantForAccessibility(2);
                    return avatarContainer;
                }
            });
            this.avatarContainer = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private final Drawable A1() {
        Bitmap decodeResource = BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), R.drawable.mh9);
        AvatarSizeType avatarSizeType = AvatarSizeType.SMALL;
        return new BitmapDrawable(getMContext().getResources(), BaseImageUtil.getCircleFaceBitmap(decodeResource, avatarSizeType.getWidth(), avatarSizeType.getHeight()));
    }

    private final Drawable B1(long msgId) {
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        if (msgId != aIOMsgItem.getMsgId()) {
            return null;
        }
        return z1().getDrawable();
    }

    private final void C1(boolean isMosaic) {
        if (isMosaic) {
            z1().setMosaicEffect(new t(10));
        } else {
            z1().setMosaicEffect(null);
        }
    }

    private final boolean D1(List<Object> payloads, AIOMsgItem msgItem) {
        if (payloads.isEmpty()) {
            return true;
        }
        boolean z16 = false;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.PaiYiPai_PAYLOAD) != null) {
                    new com.tencent.qqnt.aio.paiyipai.c(z1()).c();
                    msgItem.I1(0);
                    if (QLog.isDevelopLevel()) {
                        long msgId = msgItem.getMsgId();
                        AIOMsgItem aIOMsgItem = this.aioMsgItem;
                        if (aIOMsgItem == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem = null;
                        }
                        QLog.d("AIOAvatarContentComponent", 4, "[handlePaiYiPaiPayload] msgId is " + msgId + ", uin is " + aIOMsgItem.getMsgRecord().senderUin);
                    }
                }
                if (map.get(AIOMsgItemPayloadType.VAS_AVATAR_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        AIOMsgItem aIOMsgItem2 = this.aioMsgItem;
                        if (aIOMsgItem2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem2 = null;
                        }
                        long msgId2 = aIOMsgItem2.getMsgId();
                        AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
                        if (aIOMsgItem3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem3 = null;
                        }
                        QLog.d("AIOAvatarContentComponent", 4, "[handelVasAvatarPayload] msgId is " + msgId2 + ", uin " + aIOMsgItem3.getMsgRecord().senderUin);
                    }
                    z16 = I1(z16, msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.VAS_AVATAR_PENDENT_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        AIOMsgItem aIOMsgItem4 = this.aioMsgItem;
                        if (aIOMsgItem4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem4 = null;
                        }
                        long msgId3 = aIOMsgItem4.getMsgId();
                        AIOMsgItem aIOMsgItem5 = this.aioMsgItem;
                        if (aIOMsgItem5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem5 = null;
                        }
                        QLog.i("AIOAvatarContentComponent", 4, "[handleAvatarPendentPayload]: msgId is " + msgId3 + ", uin is " + aIOMsgItem5.getMsgRecord().senderUin);
                    }
                    z16 = I1(z16, msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.LOAD_AVATAR_PENDANT_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        AIOMsgItem aIOMsgItem6 = this.aioMsgItem;
                        if (aIOMsgItem6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem6 = null;
                        }
                        long msgId4 = aIOMsgItem6.getMsgId();
                        AIOMsgItem aIOMsgItem7 = this.aioMsgItem;
                        if (aIOMsgItem7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem7 = null;
                        }
                        QLog.i("AIOAvatarContentComponent", 4, "[handleAvatarPendentPayload]: msgId is " + msgId4 + ", uin is " + aIOMsgItem7.getMsgRecord().senderUin);
                    }
                    Object obj2 = this.avatarDrawable;
                    if (obj2 != null) {
                        x1(msgItem, obj2);
                    }
                    v1();
                    z16 = I1(z16, msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.VAS_SPECIAL_SHAPE_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        AIOMsgItem aIOMsgItem8 = this.aioMsgItem;
                        if (aIOMsgItem8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem8 = null;
                        }
                        long msgId5 = aIOMsgItem8.getMsgId();
                        AIOMsgItem aIOMsgItem9 = this.aioMsgItem;
                        if (aIOMsgItem9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem9 = null;
                        }
                        long j3 = aIOMsgItem9.getMsgRecord().senderUin;
                        AIOMsgItem aIOMsgItem10 = this.aioMsgItem;
                        if (aIOMsgItem10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                            aIOMsgItem10 = null;
                        }
                        QLog.i("AIOAvatarContentComponent", 4, "[handleVasAvatarSpecialShapePayload]: msgId is " + msgId5 + ", uin is " + j3 + ", pendantDrawable is " + aIOMsgItem10.o0());
                    }
                    z16 = I1(z16, msgItem);
                }
            }
        }
        return false;
    }

    private final void E1() {
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        f fVar = new f(aIOMsgItem, false, 2, defaultConstructorMarker);
        sendIntent(fVar);
        this.isTempChat = fVar.b();
    }

    private final boolean F1() {
        c cVar = new c(false, 1, null);
        sendIntent(cVar);
        return cVar.a();
    }

    private final boolean G1(AIOMsgItem msgItem) {
        if (msgItem != null && com.tencent.mobileqq.aio.utils.d.b0(msgItem) && msgItem.getMsgRecord().multiTransInfo != null && msgItem.getMsgRecord().multiTransInfo.friendFlag == 1) {
            return true;
        }
        return false;
    }

    private final void H1(Context context, AIOMsgItem msgItem) {
        String str;
        boolean z16;
        String str2;
        String currentUid;
        MsgRecord msgRecord = msgItem.getMsgRecord();
        if (com.tencent.mobileqq.aio.msglist.holder.component.avatar.d.f190716a.b(msgRecord, z1())) {
            return;
        }
        String str3 = msgRecord.senderUid;
        String valueOf = String.valueOf(msgRecord.senderUin);
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        i e06 = aIOMsgItem.e0();
        AIOMsgItem aIOMsgItem2 = this.aioMsgItem;
        if (aIOMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem2 = null;
        }
        j f06 = aIOMsgItem2.f0();
        boolean z17 = false;
        if (msgItem.C() == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUid();
            } else {
                str = null;
            }
            if (str != null && !str.equals(str3)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                e06 = null;
                f06 = null;
            }
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 != null && (currentUid = peekAppRuntime2.getCurrentUid()) != null) {
                str3 = currentUid;
            }
            AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime3 != null) {
                str2 = peekAppRuntime3.getCurrentUin();
            } else {
                str2 = null;
            }
            if (str2 != null) {
                valueOf = str2;
            }
        }
        String uid = str3;
        b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
        b.a aVar = new b.a();
        aVar.g(AvatarSizeType.SMALL);
        aVar.b(Integer.valueOf(R.drawable.f160830com));
        aVar.e(this);
        IAvatarOutboundApi iAvatarOutboundApi = (IAvatarOutboundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAvatarOutboundApi.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        aVar.d(iAvatarOutboundApi.getOutboundInfo(valueOf, uid));
        aVar.h(e06);
        aVar.i(f06);
        aVar.c(z1().getDrawable());
        com.tencent.qqnt.avatar.b a16 = aVar.a();
        this.avatarDrawable = null;
        if (G1(msgItem)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOAvatarContentComponent", 4, "[loadAvatar] MultiForward isUseUrlShowAvatar: msgId is " + msgItem.getMsgId());
            }
            z17 = true;
        }
        if (z17) {
            String str4 = msgItem.getMsgRecord().multiTransInfo.fromFaceUrl;
            if (TextUtils.isEmpty(str4)) {
                QLog.i("AIOAvatarContentComponent", 1, "[loadAvatar]: avatarUrl is empty, use defaultFace");
                z1().setImageDrawable(A1());
                return;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = A1();
            URLDrawable drawable = URLDrawable.getDrawable(str4, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(avatarUrl, options)");
            z1().setImageDrawable(drawable);
            return;
        }
        e.a.b(com.tencent.qqnt.avatar.a.INSTANCE.b(context).b(z1()).e(a16), uid, Long.parseLong(valueOf), null, 4, null);
    }

    private final boolean I1(boolean isCallLoadAvatar, AIOMsgItem msgItem) {
        if (com.tencent.mobileqq.aio.utils.d.s(msgItem)) {
            return true;
        }
        if (!isCallLoadAvatar) {
            H1(getMContext(), msgItem);
            return true;
        }
        return isCallLoadAvatar;
    }

    private final boolean J1() {
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        e eVar = new e(aIOMsgItem, false, 2, defaultConstructorMarker);
        sendIntent(eVar);
        return eVar.b();
    }

    private final void K1(int visibility) {
        z1().setVisibility(visibility);
    }

    private final void L1() {
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        String str = null;
        byte b16 = 0;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        if (aIOMsgItem.isSelf()) {
            z1().setContentDescription(HardCodeUtil.qqStr(R.string.f170200yp3) + HardCodeUtil.qqStr(R.string.yoz));
            return;
        }
        AIOMsgItem aIOMsgItem2 = this.aioMsgItem;
        if (aIOMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem2 = null;
        }
        d dVar = new d(aIOMsgItem2, str, 2, b16 == true ? 1 : 0);
        sendIntent(dVar);
        z1().setContentDescription(dVar.b() + HardCodeUtil.qqStr(R.string.yoz));
    }

    private final void r1() {
        AvatarContainer y16 = y1();
        y16.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.avatar.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean s16;
                s16 = AIOAvatarContentComponent.s1(AIOAvatarContentComponent.this, view);
                return s16;
            }
        });
        y16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.avatar.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOAvatarContentComponent.u1(AIOAvatarContentComponent.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s1(AIOAvatarContentComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOMsgItem aIOMsgItem = this$0.aioMsgItem;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        this$0.sendIntent(new a(aIOMsgItem));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(AIOAvatarContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOMsgItem aIOMsgItem = this$0.aioMsgItem;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        this$0.sendIntent(new b(aIOMsgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v1() {
        if (y1().getTag(R.id.sgz) != null || this.isTempChat) {
            return;
        }
        boolean enableTalkBack = com.tencent.qqnt.util.b.f362976b.enableTalkBack();
        boolean s16 = AIOUtil.f194084a.s(this);
        if (!enableTalkBack && !s16) {
            com.tencent.qqnt.aio.paiyipai.b bVar = new com.tencent.qqnt.aio.paiyipai.b();
            AIOMsgItem aIOMsgItem = this.aioMsgItem;
            if (aIOMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem = null;
            }
            bVar.b(Long.valueOf(aIOMsgItem.getMsgId()));
            com.tencent.qqnt.aio.paiyipai.a aVar = new com.tencent.qqnt.aio.paiyipai.a(getMContext(), bVar, new Handler(Looper.getMainLooper()));
            bVar.a(aVar);
            y1().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.avatar.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean w16;
                    w16 = AIOAvatarContentComponent.w1(view, motionEvent);
                    return w16;
                }
            });
            y1().setTag(R.id.sgz, aVar);
            aVar.b(y1());
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AIOAvatarContentComponent", 4, "enableTalkBack " + enableTalkBack + " isMultiForward " + s16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w1(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Object tag = view.getTag(R.id.sgz);
        if (tag instanceof GestureDetector) {
            gestureDetector = (GestureDetector) tag;
        } else {
            gestureDetector = null;
        }
        if (gestureDetector == null) {
            return false;
        }
        gestureDetector.setIsLongpressEnabled(true);
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private final void x1(AIOMsgItem msgItem, Object drawable) {
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        if (!aIOMsgItem.J() || msgItem.D()) {
            return;
        }
        if (drawable == null) {
            QLog.i("AIOAvatarContentComponent", 1, "[bindAvatarEggLayout]: drawable is null");
        } else {
            msgItem.m1(true);
            sendIntent(new d.ah(new com.tencent.qqnt.aio.refresher.b(getMContext(), msgItem, drawable, com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.k(this))));
        }
    }

    private final AvatarContainer y1() {
        return (AvatarContainer) this.avatarContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CommonImageView z1() {
        return (CommonImageView) this.avatarView.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        AIOMsgItem aIOMsgItem;
        AIOMsgItem aIOMsgItem2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        AIOMsgItem aIOMsgItem3 = (AIOMsgItem) msgItem;
        this.aioMsgItem = aIOMsgItem3;
        if (J1()) {
            y1().setVisibility(8);
            return;
        }
        y1().setVisibility(0);
        if (!D1(payloads, aIOMsgItem3)) {
            return;
        }
        r1();
        AIOMsgItem aIOMsgItem4 = null;
        if (!((IAIOAvatarApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOAvatarApi.class)).useCircleImageView()) {
            AIOMsgItem aIOMsgItem5 = this.aioMsgItem;
            if (aIOMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                aIOMsgItem5 = null;
            }
            if (!G1(aIOMsgItem5)) {
                z1().setCornerRadiusAndMode(0, 0);
                E1();
                Context context = z1().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "avatarView.context");
                aIOMsgItem = this.aioMsgItem;
                if (aIOMsgItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                    aIOMsgItem = null;
                }
                H1(context, aIOMsgItem);
                AvatarContainer y16 = y1();
                aIOMsgItem2 = this.aioMsgItem;
                if (aIOMsgItem2 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
                } else {
                    aIOMsgItem4 = aIOMsgItem2;
                }
                y16.setTag(aIOMsgItem4);
                v1();
                if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
                    L1();
                }
                C1(F1());
            }
        }
        z1().setCornerRadiusAndMode(ViewUtils.dip2px(20.0f), 1);
        E1();
        Context context2 = z1().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "avatarView.context");
        aIOMsgItem = this.aioMsgItem;
        if (aIOMsgItem == null) {
        }
        H1(context2, aIOMsgItem);
        AvatarContainer y162 = y1();
        aIOMsgItem2 = this.aioMsgItem;
        if (aIOMsgItem2 != null) {
        }
        y162.setTag(aIOMsgItem4);
        v1();
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
        }
        C1(F1());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return y1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.component.avatar.e();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return z1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOMsgItemUIState.SetAvatarMosaic) {
            C1(((AIOMsgItemUIState.SetAvatarMosaic) state).a());
            return;
        }
        if (state instanceof AIOAvatarUIState.GetDrawable) {
            AIOAvatarUIState.GetDrawable getDrawable = (AIOAvatarUIState.GetDrawable) state;
            getDrawable.c(B1(getDrawable.b()));
        } else if (state instanceof AIOAvatarUIState.SetVisibility) {
            K1(((AIOAvatarUIState.SetVisibility) state).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, importance);
        } else {
            y1().setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void m1(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            y1().setTraversalBeforeView(view);
        }
    }

    @Override // com.tencent.qqnt.avatar.d
    public void n(@Nullable Object result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, result);
            return;
        }
        this.avatarDrawable = result;
        AIOMsgItem aIOMsgItem = this.aioMsgItem;
        AIOMsgItem aIOMsgItem2 = null;
        if (aIOMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
            aIOMsgItem = null;
        }
        if (!aIOMsgItem.J()) {
            return;
        }
        AIOMsgItem aIOMsgItem3 = this.aioMsgItem;
        if (aIOMsgItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioMsgItem");
        } else {
            aIOMsgItem2 = aIOMsgItem3;
        }
        x1(aIOMsgItem2, result);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return y1();
    }
}
