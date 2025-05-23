package com.tencent.qqnt.aio.bottombar.sectionbar;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarMviUIState;
import com.tencent.qqnt.aio.bottombar.sectionbar.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.event.BottomSectionBarEvent;
import com.tencent.qqnt.aio.bottombar.sectionbar.loader.c;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.doutu.event.DoutuEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006*\u000248\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001AB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016R\u0016\u0010'\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R!\u0010.\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R'\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R(\u0010>\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010<0(0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/b;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarMviUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "Lkotlin/collections/ArrayList;", "modelList", "D", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "y", "u", "t", UserInfo.SEX_FEMALE, "r", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "mode", "add", "o", "p", ReportConstant.COSTREPORT_PREFIX, QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", HippyTKDListViewAdapter.X, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "I", "modeStateFlag", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "f", "Lkotlin/Lazy;", "v", "()Ljava/util/List;", "processorInstantsList", "", h.F, "w", "()Ljava/util/Map;", "sectionDataMap", "com/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM$b", "i", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM$b;", "mAction", "com/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM$c;", "selfAbility", "", "Ljava/util/Map;", "messageListMap", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class BottomSectionBarVM extends com.tencent.qqnt.aio.baseVM.a<com.tencent.qqnt.aio.bottombar.sectionbar.b, BottomSectionBarMviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, List<String>> messageListMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int modeStateFlag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy processorInstantsList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sectionDataMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c selfAbility;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM$a;", "", "", "AVATAR_SHOW_MODE", "I", "DOUTU_SHOW_MODE", "EMOTION_KEYWORD_MODE", "INPUT_FULL_SCREEN_MODE", "LONG_SHOT_MODE", "MODE_STATE_MASK", "MULTI_SELECT_MODE", "PANEL_SHOW_MODE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarVM$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BottomSectionBarVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                BottomSectionBarVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/aio/bottombar/sectionbar/BottomSectionBarVM$c", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/a;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "model", "", "a", "", "sectionType", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "c", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.qqnt.aio.bottombar.sectionbar.processor.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BottomSectionBarVM.this);
            }
        }

        @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.a
        public void a(@NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.b model) {
            ArrayList arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
                return;
            }
            Intrinsics.checkNotNullParameter(model, "model");
            if (QLog.isDevelopLevel()) {
                QLog.d("BottomSectionBarVM", 1, "onSubmitSection sectionType=" + model.b() + ", size=" + model.a().size());
            }
            BottomSectionBarVM bottomSectionBarVM = BottomSectionBarVM.this;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(model);
            bottomSectionBarVM.D(arrayListOf);
        }

        @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.a
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return BottomSectionBarVM.this.u();
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }

        @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.a
        public void c(int sectionType, @NotNull MviUIState state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, sectionType, (Object) state);
                return;
            }
            Intrinsics.checkNotNullParameter(state, "state");
            if (QLog.isDevelopLevel()) {
                QLog.d("BottomSectionBarVM", 1, "updateUI sectionType=" + sectionType + ", state=" + state);
            }
            BottomSectionBarVM.this.updateUI(new BottomSectionBarMviUIState.BusinessUIState(sectionType, state));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BottomSectionBarVM() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends BottomSectionBarBaseProcessor>>() { // from class: com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarVM$processorInstantsList$2
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes23.dex */
                public static final class a<T> implements Comparator {
                    static IPatchRedirector $redirector_;

                    public a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t16, T t17) {
                        int compareValues;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((BottomSectionBarBaseProcessor) t17).e()), Integer.valueOf(((BottomSectionBarBaseProcessor) t16).e()));
                            return compareValues;
                        }
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BottomSectionBarVM.this);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
                
                    r0 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r0, new com.tencent.qqnt.aio.bottombar.sectionbar.BottomSectionBarVM$processorInstantsList$2.a());
                 */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final List<? extends BottomSectionBarBaseProcessor> invoke() {
                    List<? extends BottomSectionBarBaseProcessor> sortedWith;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (List) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    c a16 = com.tencent.qqnt.aio.bottombar.sectionbar.loader.a.f349818a.a(((com.tencent.aio.api.runtime.a) BottomSectionBarVM.this.getMContext()).g().r().c().e());
                    return (a16 == null || (r0 = a16.a()) == null || sortedWith == null) ? new ArrayList() : sortedWith;
                }
            });
            this.processorInstantsList = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(BottomSectionBarVM$sectionDataMap$2.INSTANCE);
            this.sectionDataMap = lazy2;
            this.mAction = new b();
            this.selfAbility = new c();
            this.messageListMap = new LinkedHashMap();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void A(com.tencent.aio.api.runtime.a context) {
        q(context);
        B(context);
        Iterator<T> it = v().iterator();
        while (it.hasNext()) {
            ((BottomSectionBarBaseProcessor) it.next()).l();
        }
    }

    private final void B(com.tencent.aio.api.runtime.a context) {
        context.e().f(this, this.mAction);
        ArrayList<String> arrayList = new ArrayList();
        for (BottomSectionBarBaseProcessor bottomSectionBarBaseProcessor : v()) {
            List<String> m3 = bottomSectionBarBaseProcessor.m();
            this.messageListMap.put(Integer.valueOf(bottomSectionBarBaseProcessor.f()), m3);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, m3);
        }
        for (String str : arrayList) {
            j e16 = context.e();
            b bVar = this.mAction;
            LifecycleOwner d16 = context.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            e16.c(str, bVar, d16);
        }
    }

    private final void C() {
        updateUI(BottomSectionBarMviUIState.ShowBottomSectionBar.f349783d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> modelList) {
        for (com.tencent.qqnt.aio.bottombar.sectionbar.model.b bVar : modelList) {
            w().put(Integer.valueOf(bVar.b()), bVar);
        }
        if (u()) {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.b> arrayListOf;
        boolean z16 = false;
        if (intent instanceof BottomSectionBarEvent.AddSection) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(((BottomSectionBarEvent.AddSection) intent).a());
            D(arrayListOf);
            return;
        }
        if (intent instanceof BottomSectionBarEvent.AddSections) {
            D(((BottomSectionBarEvent.AddSections) intent).a());
            return;
        }
        if (intent instanceof BottomSectionBarEvent.HideBottomSectionBar) {
            z();
            return;
        }
        if (intent instanceof BottomSectionBarEvent.ShowBottomSectionBar) {
            C();
            return;
        }
        if (intent instanceof ThemeEvent.PostThemeChanged) {
            updateUI(BottomSectionBarMviUIState.PostThemeChanged.f349782d);
            return;
        }
        if (intent instanceof AIOMsgListEvent.InputToolBarChanged) {
            if (u()) {
                if (((AIOMsgListEvent.InputToolBarChanged) intent).a()) {
                    z();
                    return;
                } else {
                    C();
                    return;
                }
            }
            return;
        }
        boolean y16 = y(intent);
        if (t(intent) || y16) {
            z16 = true;
        }
        if (z16) {
            if (u()) {
                F();
            } else {
                z();
            }
        }
    }

    private final void F() {
        ArrayList<com.tencent.qqnt.aio.bottombar.sectionbar.model.a> a16;
        ArrayList arrayList = new ArrayList();
        for (BottomSectionBarBaseProcessor bottomSectionBarBaseProcessor : v()) {
            com.tencent.qqnt.aio.bottombar.sectionbar.model.b bVar = w().get(Integer.valueOf(bottomSectionBarBaseProcessor.f()));
            boolean z16 = false;
            if (bVar != null && (a16 = bVar.a()) != null && (!a16.isEmpty())) {
                z16 = true;
            }
            if (z16 && bottomSectionBarBaseProcessor.j()) {
                com.tencent.qqnt.aio.bottombar.sectionbar.model.b bVar2 = w().get(Integer.valueOf(bottomSectionBarBaseProcessor.f()));
                Intrinsics.checkNotNull(bVar2);
                arrayList.add(bVar2);
            } else {
                arrayList.add(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(bottomSectionBarBaseProcessor.f(), new ArrayList()));
            }
        }
        updateUI(new BottomSectionBarMviUIState.SubmitSections(arrayList));
    }

    private final void o(int mode, boolean add) {
        if (add) {
            p(mode);
        } else {
            s(mode);
        }
    }

    private final void p(int mode) {
        this.modeStateFlag = (mode & 127) | this.modeStateFlag;
    }

    private final void q(com.tencent.aio.api.runtime.a context) {
        Iterator<T> it = v().iterator();
        while (it.hasNext()) {
            ((BottomSectionBarBaseProcessor) it.next()).b(this.selfAbility, context, vmScope());
        }
    }

    private final void r() {
        this.modeStateFlag = 0;
    }

    private final void s(int mode) {
        this.modeStateFlag = (~(mode & 127)) & this.modeStateFlag;
    }

    private final boolean t(MsgIntent intent) {
        boolean z16;
        while (true) {
            boolean z17 = false;
            for (BottomSectionBarBaseProcessor bottomSectionBarBaseProcessor : v()) {
                List<String> list = this.messageListMap.get(Integer.valueOf(bottomSectionBarBaseProcessor.f()));
                if (list != null && list.contains(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(intent.getClass())))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (bottomSectionBarBaseProcessor.h(intent) || z17) {
                        z17 = true;
                    }
                }
            }
            return z17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        if ((this.modeStateFlag & 127) == 0) {
            return true;
        }
        return false;
    }

    private final List<BottomSectionBarBaseProcessor> v() {
        return (List) this.processorInstantsList.getValue();
    }

    private final Map<Integer, com.tencent.qqnt.aio.bottombar.sectionbar.model.b> w() {
        return (Map) this.sectionDataMap.getValue();
    }

    private final boolean y(MsgIntent intent) {
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            o(4, ((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent).b());
        } else if (intent instanceof AIOMsgListEvent.AddAvatarAreaView) {
            o(32, true);
        } else if (intent instanceof AIOMsgListEvent.RemoveAvatarAreaView) {
            o(32, false);
        } else if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            o(2, ((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
        } else if (intent instanceof DoutuEvent.OnShowOrHideDoutuEvent) {
            o(16, ((DoutuEvent.OnShowOrHideDoutuEvent) intent).a());
        } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            o(1, ((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
        } else {
            if (!(intent instanceof FullScreenMsgIntent.SetFullScreenMode)) {
                return false;
            }
            o(64, ((FullScreenMsgIntent.SetFullScreenMode) intent).a());
        }
        return true;
    }

    private final void z() {
        updateUI(BottomSectionBarMviUIState.HideBottomSectionBar.f349781d);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.qqnt.doutu.event.DoutuEvent.OnShowOrHideDoutuEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.AddAvatarAreaView");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.RemoveAvatarAreaView");
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.SetFullScreenMode");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.InputToolBarChanged");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        A(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = v().iterator();
        while (it.hasNext()) {
            ((BottomSectionBarBaseProcessor) it.next()).k();
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        Iterator<Map.Entry<Integer, List<String>>> it5 = this.messageListMap.entrySet().iterator();
        while (it5.hasNext()) {
            Iterator<T> it6 = it5.next().getValue().iterator();
            while (it6.hasNext()) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) it6.next(), this.mAction);
            }
        }
        r();
        z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.bottombar.sectionbar.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(((b.a) intent).a());
            return;
        }
        if (intent instanceof b.C9471b) {
            for (BottomSectionBarBaseProcessor bottomSectionBarBaseProcessor : v()) {
                b.C9471b c9471b = (b.C9471b) intent;
                if (bottomSectionBarBaseProcessor.f() == c9471b.b()) {
                    bottomSectionBarBaseProcessor.i(c9471b.a());
                }
            }
        }
    }
}
