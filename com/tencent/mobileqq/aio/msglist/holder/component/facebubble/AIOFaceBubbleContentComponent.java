package com.tencent.mobileqq.aio.msglist.holder.component.facebubble;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.FaceBubbleMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOPEPanelApi;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.SmallYellowFaceInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u000f\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J&\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00100'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R#\u0010;\u001a\n 7*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/AIOFaceBubbleContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/FaceBubbleMsgItem;", "", "P1", "O1", "", "serverCode", "S1", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "listener", "R1", "Lcom/tencent/image/URLDrawable;", "U1", "", "T1", "", "", "payloads", "N1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "bubblePlayStateCache", "Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/PokeEmoItemView;", "D", "Lkotlin/Lazy;", "M1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/PokeEmoItemView;", "emoIv", "Landroid/widget/RelativeLayout;", "E", "K1", "()Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "L1", "()Landroid/graphics/drawable/Drawable;", "defaultDrawable", "<init>", "(Landroid/content/Context;)V", "G", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOFaceBubbleContentComponent extends BaseContentComponent<FaceBubbleMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, Boolean> bubblePlayStateCache;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy emoIv;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy container;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/facebubble/AIOFaceBubbleContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.AIOFaceBubbleContentComponent$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/facebubble/AIOFaceBubbleContentComponent$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "p0", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFaceBubbleContentComponent.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) p06);
            } else {
                QLog.d("AIOFaceBubbleContentComponent", 2, "onLoadCanceled");
                AIOFaceBubbleContentComponent.this.M1().setImageDrawable(AIOFaceBubbleContentComponent.this.L1());
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06, (Object) p16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOFaceBubbleContentComponent", 2, "onLoadFialed");
            }
            AIOFaceBubbleContentComponent.this.M1().setImageDrawable(AIOFaceBubbleContentComponent.this.L1());
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06, p16);
            } else {
                QLog.d("AIOFaceBubbleContentComponent", 2, "onLoadProgressed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOFaceBubbleContentComponent.this.U1(drawable);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47564);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOFaceBubbleContentComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.bubblePlayStateCache = new LinkedHashMap();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PokeEmoItemView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.AIOFaceBubbleContentComponent$emoIv$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFaceBubbleContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PokeEmoItemView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new PokeEmoItemView(AIOFaceBubbleContentComponent.this.getContext()) : (PokeEmoItemView) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.emoIv = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.AIOFaceBubbleContentComponent$container$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFaceBubbleContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RelativeLayout relativeLayout = new RelativeLayout(AIOFaceBubbleContentComponent.this.getContext());
                AIOFaceBubbleContentComponent aIOFaceBubbleContentComponent = AIOFaceBubbleContentComponent.this;
                int dip2px = ViewUtils.dip2px(8.0f);
                relativeLayout.setPadding(dip2px, dip2px, dip2px, dip2px);
                relativeLayout.addView(aIOFaceBubbleContentComponent.M1(), new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx(80.0f)));
                return relativeLayout;
            }
        });
        this.container = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.AIOFaceBubbleContentComponent$defaultDrawable$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFaceBubbleContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? AIOFaceBubbleContentComponent.this.getContext().getResources().getDrawable(R.drawable.d3s) : (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.defaultDrawable = lazy3;
    }

    private final RelativeLayout K1() {
        return (RelativeLayout) this.container.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable L1() {
        return (Drawable) this.defaultDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PokeEmoItemView M1() {
        return (PokeEmoItemView) this.emoIv.getValue();
    }

    private final boolean N1(List<Object> payloads) {
        boolean z16 = true;
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                if (((Map) obj).get(AIOMsgItemPayloadType.POKE_EMO_PAYLOAD) != null) {
                    QLog.d("AIOFaceBubbleContentComponent", 2, "\u6536\u5230\u4e0b\u8f7d\u5b8c\u6210\u56de\u8c03");
                    P1();
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void O1() {
        Integer num;
        int i3;
        FaceBubbleElement m26 = q1().m2();
        if (m26 == null) {
            return;
        }
        int i16 = m26.faceType;
        Integer count = m26.faceCount;
        sendIntent(c.f190787d);
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        boolean isPeResDownloaded = ((IAIOPEPanelApi) companion.a(IAIOPEPanelApi.class)).isPeResDownloaded();
        b bVar = new b();
        if (i16 == 13) {
            M1().setText(HippyTKDListViewAdapter.X + count);
            SmallYellowFaceInfo smallYellowFaceInfo = m26.yellowFaceInfo;
            if (smallYellowFaceInfo != null && (i3 = smallYellowFaceInfo.index) >= 0) {
                int convertToLocal = QQSysFaceUtil.convertToLocal(i3);
                if (QQSysFaceSwitcher.f204652a.p()) {
                    S1(i3);
                } else {
                    Drawable faceGifURLDrawable = QQSysFaceUtil.getFaceGifURLDrawable(convertToLocal);
                    QLog.d("AIOFaceBubbleContentComponent", 2, "yellowface: serverCode:" + i3 + " is setting Drawable.");
                    R1(faceGifURLDrawable, bVar);
                }
            } else {
                QLog.w("AIOFaceBubbleContentComponent", 2, "yellowface: element:" + m26 + " is abnormal.");
                M1().setImageDrawable(L1());
            }
        } else {
            M1().setText(HippyTKDListViewAdapter.X + count);
            if (isPeResDownloaded) {
                Drawable asyncEmoDrawable = ((IAIOPEPanelApi) companion.a(IAIOPEPanelApi.class)).getAsyncEmoDrawable(i16);
                QLog.d("AIOFaceBubbleContentComponent", 2, "pokeemo res is ready.");
                PokeEmoItemView M1 = M1();
                if (asyncEmoDrawable == null) {
                    asyncEmoDrawable = L1();
                }
                M1.setImageDrawable(asyncEmoDrawable);
            } else {
                QLog.w("AIOFaceBubbleContentComponent", 2, "pokeemo: res not Download.");
                M1().setImageDrawable(L1());
            }
        }
        M1().setIsSend(q1().isSelf());
        if (T1()) {
            return;
        }
        if (isPeResDownloaded && !q1().isSelf() && !q1().o2()) {
            long j3 = q1().getMsgRecord().msgId;
            Boolean bool = this.bubblePlayStateCache.get(Long.valueOf(j3));
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual(bool, bool2)) {
                QLog.d("AIOFaceBubbleContentComponent", 2, "[seq]" + q1().getMsgSeq() + "\u52a8\u753b\u5df2\u7ecf\u7f6e\u4e3a\u5df2\u64ad\u653e");
                return;
            }
            QLog.d("AIOFaceBubbleContentComponent", 2, "[seq]" + q1().getMsgSeq() + "\u5f00\u59cb\u52a8\u753b");
            this.bubblePlayStateCache.put(Long.valueOf(j3), bool2);
            q1().r2();
            Intrinsics.checkNotNullExpressionValue(count, "count");
            int intValue = count.intValue();
            SmallYellowFaceInfo smallYellowFaceInfo2 = m26.yellowFaceInfo;
            if (smallYellowFaceInfo2 != null) {
                num = Integer.valueOf(smallYellowFaceInfo2.index);
            } else {
                num = null;
            }
            sendIntent(new d(i16, intValue, num));
            return;
        }
        if (!q1().o2()) {
            q1().r2();
        }
    }

    private final void P1() {
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        Typeface typeFace = ((IAIOPEPanelApi) companion.a(IAIOPEPanelApi.class)).getTypeFace();
        if (typeFace != null) {
            M1().setTypeFace(typeFace);
        } else if (((IAIOPEPanelApi) companion.a(IAIOPEPanelApi.class)).isPeResDownloaded() && !((IAIOPEPanelApi) companion.a(IAIOPEPanelApi.class)).isTypefaceLoading()) {
            ((IAIOPEPanelApi) companion.a(IAIOPEPanelApi.class)).setTypefaceLoading(true);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.facebubble.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOFaceBubbleContentComponent.Q1();
                }
            }, 64, null, false);
        }
        M1().setContentDescription(q1().f1());
        O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1() {
        ((IAIOPEPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPEPanelApi.class)).loadFontTypeface();
    }

    private final void R1(Drawable drawable, URLDrawable.URLDrawableListener listener) {
        if (drawable instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getStatus() == 1) {
                U1(uRLDrawable);
                return;
            }
            QLog.d("AIOFaceBubbleContentComponent", 2, "downloadImediatly.");
            uRLDrawable.setURLDrawableListener(listener);
            uRLDrawable.downloadImediatly(true);
            return;
        }
        M1().setImageDrawable(L1());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void S1(int serverCode) {
        boolean z16;
        boolean isBlank;
        Pair<String, Boolean> sysFaceFullResPath = QQSysAndEmojiResMgr.getInstance().getSysFaceFullResPath(4, serverCode);
        Intrinsics.checkNotNullExpressionValue(sysFaceFullResPath, "getInstance().getSysFace\u2026S_QQSYS_APNG, serverCode)");
        CharSequence charSequence = (CharSequence) sysFaceFullResPath.first;
        if (charSequence != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    a.C1005a i3 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
                    Object obj = sysFaceFullResPath.first;
                    Intrinsics.checkNotNullExpressionValue(obj, "pair.first");
                    M1().setImageDrawable(i3.d((String) obj).a());
                    return;
                }
                M1().setImageDrawable(L1());
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final boolean T1() {
        if (q1().v().chatType != 1) {
            QLog.d("AIOFaceBubbleContentComponent", 2, "[seq]" + q1().getMsgSeq() + "\u975eC2C \u4e0d\u64ad\u653e");
            return true;
        }
        if (q1().getMsgRecord().sendType != 1 && q1().getMsgRecord().sendType != 0) {
            QLog.d("AIOFaceBubbleContentComponent", 2, "[seq]" + q1().getMsgSeq() + "\u975e\u63a5\u6536\u6216\u81ea\u5df1\u53d1\u9001\u7684\u6d88\u606f \u4e0d\u64ad\u653e");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(URLDrawable drawable) {
        File file;
        Drawable drawable2 = null;
        if (drawable != null) {
            file = drawable.getFileInLocal();
        } else {
            file = null;
        }
        if (file != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOFaceBubbleContentComponent", 2, "setDrawableToEmoIV " + file.getCanonicalPath() + ".");
            }
            if (drawable != null) {
                drawable2 = drawable.getCurrDrawable();
            }
            if (drawable2 instanceof GifDrawable) {
                M1().setImageDrawable(drawable);
                return;
            }
            a.C1005a i3 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().i(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
            String canonicalPath = file.getCanonicalPath();
            Intrinsics.checkNotNullExpressionValue(canonicalPath, "path.canonicalPath");
            M1().setImageDrawable(i3.d(canonicalPath).a());
            return;
        }
        QLog.d("AIOFaceBubbleContentComponent", 2, "setDrawableToEmoIV path is null.");
        M1().setImageDrawable(L1());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (N1(payloads)) {
            P1();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return K1();
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.component.facebubble.b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new ad(getMContext(), q1(), this), new h(getMContext(), q1(), this)});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }
}
