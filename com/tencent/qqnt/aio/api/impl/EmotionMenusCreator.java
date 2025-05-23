package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.aio.emoreply.AIOEmoReplySelectMsgEvent;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001\"B\u0019\u0012\u0006\u0010$\u001a\u00020!\u0012\b\u0010'\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J(\u0010\u0010\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002J \u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011J\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u000bR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/EmotionMenusCreator;", "", "Landroid/widget/ImageView;", "k", "", "scale", "l", "", "index", "Landroid/view/View$OnClickListener;", "listener", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "width", "height", "Lcom/tencent/qqnt/aio/api/impl/ae;", "r", "", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "o", "anchorView", HippyNestedScrollComponent.PRIORITY_PARENT, "", "i", "imageView", "emotion", tl.h.F, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "it", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "safeGetCurrentMsgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class EmotionMenusCreator {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AIOMsgItem safeGetCurrentMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/EmotionMenusCreator$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.EmotionMenusCreator$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/api/impl/EmotionMenusCreator$b", "Lcom/tencent/qqnt/aio/api/impl/ae;", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "view", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements ae {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f348899b;

        b(View view) {
            this.f348899b = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmotionMenusCreator.this, (Object) view);
            }
        }

        @Override // com.tencent.qqnt.aio.api.impl.ae
        public boolean a(@NotNull View parent, @NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, (Object) view)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(view, "view");
            EmotionMenusCreator.this.i(this.f348899b, parent);
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmotionMenusCreator(@NotNull Context context, @Nullable AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aIOMsgItem);
        } else {
            this.context = context;
            this.safeGetCurrentMsgItem = aIOMsgItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(ImageView imageView, SystemAndEmojiEmotionInfo emotion) {
        ViewGroup viewGroup;
        ViewParent viewParent;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        View view;
        ImageView imageView2;
        Drawable drawable;
        FragmentActivity fragmentActivity;
        String joinToString$default;
        n.m("clickEmotionIcon localID=" + emotion.getCode() + " type=" + emotion.c());
        AIOMsgItem aIOMsgItem = this.safeGetCurrentMsgItem;
        if (aIOMsgItem == null || q(aIOMsgItem)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("longpress_message_type", Integer.valueOf(aIOMsgItem.getMsgRecord().msgType));
        hashMap.put("aio_longpress_menu_action_item", "14");
        hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, Integer.valueOf(((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToServer(emotion.getCode(), emotion.c())));
        hashMap.put("touin", Long.valueOf(aIOMsgItem.getMsgRecord().senderUin));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_long_menu", hashMap);
        Unit unit = null;
        if (QLog.isDevelopLevel() || QQSysFaceSwitcher.f204652a.b()) {
            ViewParent parent = imageView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewParent = viewGroup.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewParent;
            } else {
                viewGroup2 = null;
            }
            if (viewGroup2 != null) {
                int childCount = viewGroup2.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup2.getChildAt(i3);
                    float scaleX = childAt.getScaleX();
                    float scaleY = childAt.getScaleY();
                    int visibility = childAt.getVisibility();
                    if (childAt instanceof ViewGroup) {
                        viewGroup3 = (ViewGroup) childAt;
                    } else {
                        viewGroup3 = null;
                    }
                    if (viewGroup3 != null) {
                        view = viewGroup3.getChildAt(0);
                    } else {
                        view = null;
                    }
                    if (view instanceof ImageView) {
                        imageView2 = (ImageView) view;
                    } else {
                        imageView2 = null;
                    }
                    if (imageView2 != null) {
                        drawable = imageView2.getDrawable();
                    } else {
                        drawable = null;
                    }
                    QLog.e("EmotionMenusCreator", 1, "i:" + i3 + ", scaleX:" + scaleX + ", scaleY:" + scaleY + ", visible:" + visibility + ", drawable:" + drawable);
                }
            }
        }
        Context context = this.context;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            int[] iArr = new int[2];
            imageView.getLocationOnScreen(iArr);
            com.tencent.qqnt.aio.emoreply.h hVar = new com.tencent.qqnt.aio.emoreply.h(emotion, iArr, new int[]{0, 0}, true, null, false, null, 0, 240, null);
            int code = emotion.getCode();
            int i16 = emotion.type;
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(iArr, (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            QLog.i(AIOEmoReplyMenuApiImpl.TAG, 1, "clickEmotionIcon code:" + code + ", type:" + i16 + ", location:" + joinToString$default);
            com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, new AIOEmoReplySelectMsgEvent(emotion.getCode(), emotion.c(), aIOMsgItem.getMsgRecord(), hVar));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            n.m("context to FragmentActivity failed: " + this.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(View anchorView, View parent) {
        n.m("clickIcon moreEmotion");
        AIOMsgItem aIOMsgItem = this.safeGetCurrentMsgItem;
        if (aIOMsgItem == null || q(aIOMsgItem)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("longpress_message_type", Integer.valueOf(aIOMsgItem.getMsgRecord().msgType));
        hashMap.put("aio_longpress_menu_action_item", "15");
        hashMap.put("touin", Long.valueOf(aIOMsgItem.getMsgRecord().senderUin));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_long_menu", hashMap);
        if (anchorView != null) {
            Context context = this.context;
            if (context instanceof FragmentActivity) {
                com.tencent.qqnt.aio.utils.c.f352293a.a((FragmentActivity) context, new CreateHelperIntent.CreateHelperRealIntent(4, new AIOMsgListEvent.ShowEmoReplyMoreMenuEvent(aIOMsgItem.getMsgRecord(), anchorView, "1", IAIOEmoReplyMorePanel.Source.EMO_REPLY_MORE, parent, null, 32, null), null, 4, null));
                return;
            }
            return;
        }
        IAIOEmoReplyApi.a.b((IAIOEmoReplyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoReplyApi.class), this.context, aIOMsgItem.getMsgRecord(), null, "1", 4, null);
    }

    static /* synthetic */ void j(EmotionMenusCreator emotionMenusCreator, View view, View view2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = null;
        }
        if ((i3 & 2) != 0) {
            view2 = null;
        }
        emotionMenusCreator.i(view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView k() {
        ImageView imageView = new ImageView(this.context);
        int a16 = ViewUtils.f352270a.a(24.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a16, a16);
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView l(float scale) {
        int i3;
        int i16;
        ImageView imageView = new ImageView(this.context);
        i3 = n.f348960g;
        i16 = n.f348961h;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (i3 * scale), (int) (i16 * scale));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(EmotionMenusCreator this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j(this$0, null, null, 3, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final List<SystemAndEmojiEmotionInfo> o() {
        Contact v3;
        int i3;
        AIOMsgItem aIOMsgItem = this.safeGetCurrentMsgItem;
        if (aIOMsgItem != null && (v3 = aIOMsgItem.v()) != null) {
            int i16 = v3.chatType;
            com.tencent.qqnt.aio.emoReply.c cVar = com.tencent.qqnt.aio.emoReply.c.f349875a;
            i3 = n.f348954a;
            return cVar.f(i3 - 1, Integer.valueOf(i16));
        }
        return null;
    }

    private final boolean q(AIOMsgItem it) {
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ITroopApi iTroopApi = (ITroopApi) companion.a(ITroopApi.class);
        String str = it.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "it.msgRecord.peerUid");
        if (!iTroopApi.isGagMode(str)) {
            ITroopApi iTroopApi2 = (ITroopApi) companion.a(ITroopApi.class);
            String str2 = it.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "it.msgRecord.peerUid");
            if (!iTroopApi2.isExitTroop(str2)) {
                return false;
            }
        }
        String toast = HardCodeUtil.qqStr(R.string.ypr);
        QQToast.makeText(this.context, 1, toast, 0).show();
        HashMap hashMap = new HashMap();
        Intrinsics.checkNotNullExpressionValue(toast, "toast");
        hashMap.put("text_content", toast);
        com.tencent.mobileqq.aio.utils.b.q("em_bas_emoji_response_toast", hashMap);
        QLog.d(AIOEmoReplyMenuApiImpl.TAG, 1, "isGagMode or isExitTroop");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View r(ImageView imageView, int i3, int i16, ae aeVar) {
        int i17;
        FrameLayout frameLayout = new FrameLayout(imageView.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i3, i16));
        frameLayout.addView(imageView);
        if (aeVar != null) {
            i17 = n.f348959f;
            frameLayout.setTag(i17, aeVar);
        }
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View s(ImageView imageView, int i3, View.OnClickListener onClickListener) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        FrameLayout frameLayout = new FrameLayout(imageView.getContext());
        i16 = n.f348954a;
        if (i16 == 6) {
            i26 = n.f348955b;
            i27 = n.f348956c;
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i26, i27));
        } else {
            i17 = n.f348957d;
            i18 = n.f348958e;
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(i17, i18));
        }
        frameLayout.addView(imageView);
        if (onClickListener != null) {
            i19 = n.f348959f;
            frameLayout.setTag(i19, onClickListener);
            frameLayout.setOnClickListener(onClickListener);
        }
        return frameLayout;
    }

    @Nullable
    public final List<View> m() {
        Contact v3;
        int i3;
        Sequence asSequence;
        Sequence mapIndexed;
        Sequence filterNotNull;
        List<View> mutableList;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AIOMsgItem aIOMsgItem = this.safeGetCurrentMsgItem;
        if (aIOMsgItem != null && (v3 = aIOMsgItem.v()) != null) {
            int i17 = v3.chatType;
            com.tencent.qqnt.aio.emoReply.c cVar = com.tencent.qqnt.aio.emoReply.c.f349875a;
            i3 = n.f348954a;
            asSequence = CollectionsKt___CollectionsKt.asSequence(cVar.f(i3 - 1, Integer.valueOf(i17)));
            mapIndexed = SequencesKt___SequencesKt.mapIndexed(asSequence, new EmotionMenusCreator$getEmotionMenuItems$1(this));
            filterNotNull = SequencesKt___SequencesKt.filterNotNull(mapIndexed);
            mutableList = SequencesKt___SequencesKt.toMutableList(filterNotNull);
            ImageView k3 = k();
            k3.setImageResource(R.drawable.j6c);
            k3.setFocusable(true);
            k3.setImportantForAccessibility(1);
            AccessibilityUtil.p(k3, HardCodeUtil.qqStr(R.string.zuh));
            Unit unit = Unit.INSTANCE;
            i16 = n.f348954a;
            mutableList.add(s(k3, i16 - 1, new View.OnClickListener() { // from class: com.tencent.qqnt.aio.api.impl.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmotionMenusCreator.n(EmotionMenusCreator.this, view);
                }
            }));
            return mutableList;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        r3 = kotlin.sequences.SequencesKt___SequencesKt.mapIndexed(r3, new com.tencent.qqnt.aio.api.impl.EmotionMenusCreator$getSeparateEmotionMenuItems$1(r6, r0, r1, r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r3 = kotlin.sequences.SequencesKt___SequencesKt.filterNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        r3 = kotlin.sequences.SequencesKt___SequencesKt.toMutableList(r3);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<View> p(@NotNull View anchorView) {
        int i3;
        int i16;
        Sequence asSequence;
        Sequence mapIndexed;
        Sequence filterNotNull;
        List<View> mutableList;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) anchorView);
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        MenuUtils menuUtils = MenuUtils.f351230a;
        Context context = anchorView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "anchorView.context");
        final float k3 = menuUtils.k(context);
        i3 = n.f348963j;
        final int i18 = (int) (i3 * k3);
        i16 = n.f348962i;
        final int i19 = (int) (i16 * k3);
        List<SystemAndEmojiEmotionInfo> o16 = o();
        if (o16 != null && asSequence != null && mapIndexed != null && filterNotNull != null && mutableList != null) {
            ImageView l3 = l(k3);
            l3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            l3.setImageResource(R.drawable.qui_chevron_down_icon_allwhite_primary);
            l3.setBackgroundColor(l3.getContext().getColor(R.color.bie));
            i17 = n.f348961h;
            com.tencent.mobileqq.widget.listitem.ab.d(l3, i17 / 2.0f);
            l3.setFocusable(true);
            l3.setImportantForAccessibility(1);
            AccessibilityUtil.p(l3, HardCodeUtil.qqStr(R.string.zuh));
            Unit unit = Unit.INSTANCE;
            mutableList.add(r(l3, i18, i19, new b(anchorView)));
            return mutableList;
        }
        return null;
    }
}
