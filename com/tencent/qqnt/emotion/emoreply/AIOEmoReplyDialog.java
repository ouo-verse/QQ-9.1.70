package com.tencent.qqnt.emotion.emoreply;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallbackWithView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelController;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.aio.adapter.api.impl.AIOEmoReplyApiImpl;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0011*\u00016\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EBS\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020!\u0012\b\u0010(\u001a\u0004\u0018\u00010%\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\"\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020-`.\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0014\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R0\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020-`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog;", "Landroid/app/Dialog;", "Landroid/content/DialogInterface$OnDismissListener;", "", "initUI", "Landroid/view/View;", "m0", "Landroid/widget/ListView;", "i0", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "b0", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "e0", "f0", "d0", "l0", "initWindow", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "info", "", "g0", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "newList", "o0", "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "k0", "()Landroid/content/Context;", "mContext", "Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiImpl;", "D", "Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiImpl;", "dialogImpl", "Lcom/tencent/qqnt/aio/emoreply/j;", "E", "Lcom/tencent/qqnt/aio/emoreply/j;", "sendCallBack", UserInfo.SEX_FEMALE, "Ljava/util/List;", "recentList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "from", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "H", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "com/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog$b", "I", "Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog$b;", "emoticonCallback", "J", "Lkotlin/Lazy;", "j0", "()Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanel;", "emoticonPanel", "K", "Landroid/widget/ListView;", "emoticonListView", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyApiImpl;Lcom/tencent/qqnt/aio/emoreply/j;Ljava/util/List;Ljava/util/HashMap;)V", "L", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class AIOEmoReplyDialog extends ReportDialog implements DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AIOEmoReplyApiImpl dialogImpl;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.aio.emoreply.j sendCallBack;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<EmotionPanelData> recentList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> from;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final b emoticonCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy emoticonPanel;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ListView emoticonListView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog$a;", "", "", "CLICK_POS", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.emoreply.AIOEmoReplyDialog$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog$b", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallbackWithView;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "Landroid/view/View;", "view", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements EmoticonCallbackWithView {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmoReplyDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) info);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) info)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, oldInfo, newInfo, d16);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) info);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallbackWithView
        public void send(@Nullable EmoticonInfo info, @Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info, (Object) view);
                return;
            }
            if (info instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) info;
                int i3 = systemAndEmojiEmoticonInfo.code;
                if (i3 < 0) {
                    QLog.d("AIOEmoReplyDialog", 1, "info code error:" + i3);
                    return;
                }
                int i16 = systemAndEmojiEmoticonInfo.emotionType;
                if (i16 == 1) {
                    i3 = QQSysFaceUtil.convertToServer(i3);
                } else if (i16 == 2) {
                    i3 = QQSysAndEmojiResMgr.getInstance().getResImpl(2).getServerId(systemAndEmojiEmoticonInfo.code);
                }
                if (i3 >= 0) {
                    com.tencent.qqnt.aio.emoReply.c cVar = com.tencent.qqnt.aio.emoReply.c.f349875a;
                    int i17 = systemAndEmojiEmoticonInfo.emotionType;
                    int i18 = systemAndEmojiEmoticonInfo.code;
                    String str = systemAndEmojiEmoticonInfo.title;
                    Intrinsics.checkNotNullExpressionValue(str, "info.title");
                    cVar.k(new SystemAndEmojiEmotionInfo(i17, i18, str));
                    String g06 = AIOEmoReplyDialog.this.g0(systemAndEmojiEmoticonInfo);
                    HashMap hashMap = new HashMap(AIOEmoReplyDialog.this.from);
                    hashMap.put("click_pos", g06);
                    hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, String.valueOf(i3));
                    com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_emoticon_response_panel", hashMap);
                    com.tencent.qqnt.aio.emoreply.j jVar = AIOEmoReplyDialog.this.sendCallBack;
                    if (jVar != null) {
                        jVar.a(systemAndEmojiEmoticonInfo.emotionType, i3);
                    }
                    QLog.d("AIOEmoReplyDialog", 1, "send info.type=" + systemAndEmojiEmoticonInfo.getEmoticonType() + ", info.code=" + systemAndEmojiEmoticonInfo.code + ", serverId=" + i3);
                }
            }
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = AIOEmoReplyDialog.this.mFloatingView;
            if (qUSHalfScreenFloatingView != null) {
                qUSHalfScreenFloatingView.t();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/emotion/emoreply/AIOEmoReplyDialog$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEmoReplyDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                ListView i06 = AIOEmoReplyDialog.this.i0();
                if (i06 == null) {
                    return false;
                }
                if (i06.getFirstVisiblePosition() != 0 || i06.getTop() != 0) {
                    return true;
                }
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF58528d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIOEmoReplyDialog.this.m0();
            }
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return (int) (AIOEmoReplyDialog.this.k0().getResources().getDisplayMetrics().heightPixels * 0.75d);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOEmoReplyDialog(@NotNull Context mContext, @NotNull AIOEmoReplyApiImpl dialogImpl, @Nullable com.tencent.qqnt.aio.emoreply.j jVar, @NotNull List<? extends EmotionPanelData> recentList, @NotNull HashMap<String, Object> from) {
        super(mContext, R.style.a0g);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(dialogImpl, "dialogImpl");
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        Intrinsics.checkNotNullParameter(from, "from");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, dialogImpl, jVar, recentList, from);
            return;
        }
        this.mContext = mContext;
        this.dialogImpl = dialogImpl;
        this.sendCallBack = jVar;
        this.recentList = recentList;
        this.from = from;
        this.emoticonCallback = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IEmoticonMainPanel>() { // from class: com.tencent.qqnt.emotion.emoreply.AIOEmoReplyDialog$emoticonPanel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOEmoReplyDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IEmoticonMainPanel invoke() {
                IEmoticonMainPanel b06;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (IEmoticonMainPanel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                b06 = AIOEmoReplyDialog.this.b0();
                return b06;
            }
        });
        this.emoticonPanel = lazy;
        initWindow();
        l0();
        initUI();
        setOnDismissListener(this);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.qqnt.emotion.emoreply.e
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AIOEmoReplyDialog.Q(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(DialogInterface dialogInterface) {
        QLog.d("AIOEmoReplyDialog", 1, "onShow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IEmoticonMainPanel b0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IEmoticonMainPanelService.PanelBuilder emoticonListProvider = ((IEmoticonMainPanelService) peekAppRuntime.getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(this.mContext, 1).setCallBack(this.emoticonCallback).setDisableMoreEmotionButton(true).setToastOffset(this.mContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height)).setHideAllSettingTabs(true).keepLottieMerged(true).setCustomEmotionData(16, EmoReplyUtils.f356241a.b(this.recentList)).setFilterEmotionData(16, e0()).setEmoticonListProvider(new EmoticonListProvider() { // from class: com.tencent.qqnt.emotion.emoreply.f
            @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
            public final List getEmotionPanelInfo(boolean z16, boolean z17) {
                List c06;
                c06 = AIOEmoReplyDialog.c0(z16, z17);
                return c06;
            }
        });
        Intrinsics.checkNotNullExpressionValue(emoticonListProvider, "appRuntime.getRuntimeSer\u2026 panelData\n            })");
        IEmoticonMainPanel create = emoticonListProvider.create();
        create.hideAllTabs();
        Intrinsics.checkNotNullExpressionValue(create, "panelBuilder.create().ap\u2026  hideAllTabs()\n        }");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c0(boolean z16, boolean z17) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EmotionPanelInfo(16, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
        return arrayList;
    }

    private final List<EmotionPanelData> d0() {
        ArrayList arrayList = new ArrayList();
        List<Integer> filterEmojiData = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getFilterEmojiData();
        if (filterEmojiData == null) {
            return arrayList;
        }
        for (Integer i3 : filterEmojiData) {
            Intrinsics.checkNotNullExpressionValue(i3, "i");
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i3.intValue(), "", false));
        }
        return arrayList;
    }

    private final List<EmotionPanelData> e0() {
        List<EmotionPanelData> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) f0());
        mutableList.addAll(d0());
        return mutableList;
    }

    private final List<EmotionPanelData> f0() {
        ArrayList arrayList = new ArrayList();
        List<Integer> filterSysData = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getFilterSysData();
        if (filterSysData == null) {
            return arrayList;
        }
        for (Integer i3 : filterSysData) {
            Intrinsics.checkNotNullExpressionValue(i3, "i");
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, i3.intValue(), "", false));
        }
        Iterator<Integer> it = EmoReplyUtils.f356241a.a().iterator();
        while (it.hasNext()) {
            Integer i16 = it.next();
            Intrinsics.checkNotNullExpressionValue(i16, "i");
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, i16.intValue(), "", false));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g0(SystemAndEmojiEmoticonInfo info) {
        String str = info.title;
        if (Intrinsics.areEqual(str, SystemAndEmojiEmoticonInfo.TITLE_SYSTEM)) {
            return "2";
        }
        if (Intrinsics.areEqual(str, SystemAndEmojiEmoticonInfo.TITLE_OFTEN)) {
            return "1";
        }
        if (!Intrinsics.areEqual(str, SystemAndEmojiEmoticonInfo.TITLE_EMOJI)) {
            return "2";
        }
        return "3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView i0() {
        if (this.emoticonListView == null) {
            IEmoticonPanelController emoController = j0().getEmoController();
            if (emoController instanceof EmoticonPanelController) {
                EmoticonPanelController emoticonPanelController = (EmoticonPanelController) emoController;
                this.emoticonListView = emoticonPanelController.getPageAdapter().getAdapterFromCache(emoticonPanelController.getPanelDataList().get(0)).getCurrentListView();
            }
        }
        return this.emoticonListView;
    }

    private final void initUI() {
        setContentView(R.layout.e3i);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        this.mFloatingView = qUSHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setHeadViewBg(R.drawable.j6e);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setQUSDragFloatController(new c());
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.qqnt.emotion.emoreply.g
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    AIOEmoReplyDialog.n0(AIOEmoReplyDialog.this);
                }
            });
        }
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            QLog.d("AIOEmoReplyDialog", 1, "dialog window is null, return");
            return;
        }
        window.setLayout(-1, -1);
        window.getAttributes().gravity = 80;
        window.setNavigationBarColor(0);
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("AIOEmoReplyDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IEmoticonMainPanel j0() {
        return (IEmoticonMainPanel) this.emoticonPanel.getValue();
    }

    private final void l0() {
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View m0() {
        RelativeLayout view = j0().getView();
        Intrinsics.checkNotNullExpressionValue(view, "emoticonPanel.view");
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(AIOEmoReplyDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AIOEmoReplyDialog", 2, "floating view dismiss");
        this$0.dialogImpl.dialogDismiss();
        this$0.dismiss();
    }

    @NotNull
    public final Context k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext;
    }

    public final void o0(@NotNull List<? extends EmotionPanelData> newList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newList);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        Object obj = this.mContext;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) obj), "AIOEmoReplyDialog_updateRecentList", Boolean.TRUE, null, null, new AIOEmoReplyDialog$updateRecentList$1(newList, this, null), 12, null);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@Nullable DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dialog);
        } else {
            this.dialogImpl.dialogDismiss();
            QLog.d("AIOEmoReplyDialog", 1, "onDismiss");
        }
    }
}
