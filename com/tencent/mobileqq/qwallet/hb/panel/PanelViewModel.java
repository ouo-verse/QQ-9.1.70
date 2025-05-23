package com.tencent.mobileqq.qwallet.hb.panel;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.MainThread;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.panel.PanelViewModel;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\"\u0010\u0016\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00030\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R#\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/PanelViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "rawList", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "U1", "", WadlProxyConsts.SCENE_ID, "X1", "N1", "W1", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qwallet/hb/panel/b;", "recommendSkinHost", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", SkinResFactory.SKIN_THEME_APK_SAVE_DIR, "R1", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "i", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "Q1", "()Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "skinRecommendVM", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "bottomTabsLiveData", "Landroidx/lifecycle/MediatorLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MediatorLiveData;", "P1", "()Landroidx/lifecycle/MediatorLiveData;", "hbEntryLiveData", "", "D", "Z", "T1", "()Z", "Z1", "(Z)V", "isUpdateBySuccess", "<init>", "()V", "E", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PanelViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<PanelEntryData>> hbEntryLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean isUpdateBySuccess;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SkinRecommendViewModel skinRecommendVM;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<PanelTabData>> bottomTabsLiveData;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J$\u0010\u000e\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/PanelViewModel$b", "Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$a;", "", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "cacheEntryList", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "cacheTabList", "", "b", "entryList", "panelTabList", "a", "defaultEntryList", "defaultTabList", "c", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements RedPacketManager.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(PanelViewModel this$0, List cacheEntryList, List cacheTabList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(cacheEntryList, "$cacheEntryList");
            Intrinsics.checkNotNullParameter(cacheTabList, "$cacheTabList");
            this$0.a2(cacheEntryList);
            this$0.O1().setValue(cacheTabList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(PanelViewModel this$0, List defaultEntryList, List defaultTabList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(defaultEntryList, "$defaultEntryList");
            Intrinsics.checkNotNullParameter(defaultTabList, "$defaultTabList");
            this$0.a2(defaultEntryList);
            this$0.O1().setValue(defaultTabList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(PanelViewModel this$0, List entryList, List panelTabList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(entryList, "$entryList");
            Intrinsics.checkNotNullParameter(panelTabList, "$panelTabList");
            this$0.a2(entryList);
            this$0.O1().setValue(panelTabList);
        }

        @Override // com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager.a
        public void a(@NotNull final List<PanelEntryData> entryList, @NotNull final List<PanelTabData> panelTabList) {
            Intrinsics.checkNotNullParameter(entryList, "entryList");
            Intrinsics.checkNotNullParameter(panelTabList, "panelTabList");
            PanelViewModel.this.Z1(true);
            QLog.d("PanelViewModel", 1, "onSuccess: entrySize=" + entryList.size() + " tabSize=" + panelTabList.size());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PanelViewModel panelViewModel = PanelViewModel.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.panel.h
                @Override // java.lang.Runnable
                public final void run() {
                    PanelViewModel.b.i(PanelViewModel.this, entryList, panelTabList);
                }
            });
        }

        @Override // com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager.a
        public void b(@NotNull final List<PanelEntryData> cacheEntryList, @NotNull final List<PanelTabData> cacheTabList) {
            Intrinsics.checkNotNullParameter(cacheEntryList, "cacheEntryList");
            Intrinsics.checkNotNullParameter(cacheTabList, "cacheTabList");
            QLog.d("PanelViewModel", 1, "onCache: entrySize=" + cacheEntryList.size() + " tabSize=" + cacheTabList.size());
            if (PanelViewModel.this.getIsUpdateBySuccess()) {
                QLog.d("PanelViewModel", 1, "onCache: isUpdateBySuccess=true, return");
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PanelViewModel panelViewModel = PanelViewModel.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.panel.g
                @Override // java.lang.Runnable
                public final void run() {
                    PanelViewModel.b.g(PanelViewModel.this, cacheEntryList, cacheTabList);
                }
            });
        }

        @Override // com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager.a
        public void c(@NotNull final List<PanelEntryData> defaultEntryList, @NotNull final List<PanelTabData> defaultTabList) {
            Intrinsics.checkNotNullParameter(defaultEntryList, "defaultEntryList");
            Intrinsics.checkNotNullParameter(defaultTabList, "defaultTabList");
            QLog.e("PanelViewModel", 1, "onFail: entrySize=" + defaultEntryList.size() + " tabSize=" + defaultTabList.size());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PanelViewModel panelViewModel = PanelViewModel.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.panel.i
                @Override // java.lang.Runnable
                public final void run() {
                    PanelViewModel.b.h(PanelViewModel.this, defaultEntryList, defaultTabList);
                }
            });
        }
    }

    public PanelViewModel() {
        SkinRecommendViewModel skinRecommendViewModel = new SkinRecommendViewModel();
        this.skinRecommendVM = skinRecommendViewModel;
        this.bottomTabsLiveData = new MutableLiveData<>();
        final MediatorLiveData<List<PanelEntryData>> mediatorLiveData = new MediatorLiveData<>();
        MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> Z1 = skinRecommendViewModel.Z1();
        final Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.PanelViewModel$hbEntryLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.qwallet.pb.a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.mobileqq.qwallet.pb.a> list) {
                PanelViewModel.this.a2(mediatorLiveData.getValue());
            }
        };
        mediatorLiveData.addSource(Z1, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.panel.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PanelViewModel.S1(Function1.this, obj);
            }
        });
        this.hbEntryLiveData = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if ((!r0.isEmpty()) == true) goto L10;
     */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a2(List<PanelEntryData> rawList) {
        boolean z16;
        if (rawList == null) {
            return;
        }
        if (this.skinRecommendVM.Z1().getValue() != null) {
            z16 = true;
        }
        z16 = false;
        this.hbEntryLiveData.setValue((!z16 || rawList.size() <= 4) ? CollectionsKt___CollectionsKt.toList(rawList) : CollectionsKt___CollectionsKt.slice((List) rawList, new IntRange(0, 3)));
    }

    public final void N1() {
        this.skinRecommendVM.R1();
    }

    @NotNull
    public final MutableLiveData<List<PanelTabData>> O1() {
        return this.bottomTabsLiveData;
    }

    @NotNull
    public final MediatorLiveData<List<PanelEntryData>> P1() {
        return this.hbEntryLiveData;
    }

    @NotNull
    /* renamed from: Q1, reason: from getter */
    public final SkinRecommendViewModel getSkinRecommendVM() {
        return this.skinRecommendVM;
    }

    public final void R1(@Nullable Context context, @Nullable com.tencent.mobileqq.qwallet.hb.panel.b recommendSkinHost, @NotNull RedPackSkin$RecommendSkin skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        this.skinRecommendVM.a2(context, recommendSkinHost, skin);
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getIsUpdateBySuccess() {
        return this.isUpdateBySuccess;
    }

    public final void U1(@NotNull p sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.isUpdateBySuccess = false;
        m.f277567a.b(sessionInfo, new b());
    }

    public final void W1() {
        this.skinRecommendVM.f2();
    }

    public final void X1(int sceneId) {
        SkinRecommendViewModel.n2(this.skinRecommendVM, sceneId, null, 2, null);
    }

    public final void Z1(boolean z16) {
        this.isUpdateBySuccess = z16;
    }
}
