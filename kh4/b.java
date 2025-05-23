package kh4;

import android.content.Context;
import android.view.View;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import fh4.g;
import gh4.f;
import java.util.List;
import kh4.b;
import kh4.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.RecommendProxyOuterClass$GetTopKuolieRoomListRsp;
import trpc.yes.common.RecommendProxyOuterClass$KuolieRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0006*\u0001\u001c\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001d\u00a8\u0006!"}, d2 = {"Lkh4/b;", "", "Landroid/view/View;", "view", "", "e", "changeRoomView", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "param", "Lhh4/a;", "info", "f", h.F, "d", "", "a", "Ljava/lang/String;", "TAG", "", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "b", "Ljava/util/List;", "userRoomList", "c", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Lhh4/a;", "gmChangeRoomInfo", "kh4/b$b", "Lkh4/b$b;", "itemClickListener", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<RecommendProxyOuterClass$KuolieRoomInfo> userRoomList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExpandHallLaunchParam launchParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private hh4.a gmChangeRoomInfo;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "ExpandHallGMManager";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10660b itemClickListener = new C10660b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"kh4/b$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$GetTopKuolieRoomListRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<View> f412412b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExpandHallLaunchParam f412413c;

        a(WeakReference<View> weakReference, ExpandHallLaunchParam expandHallLaunchParam) {
            this.f412412b = weakReference;
            this.f412413c = expandHallLaunchParam;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable RecommendProxyOuterClass$GetTopKuolieRoomListRsp result) {
            List<RecommendProxyOuterClass$KuolieRoomInfo> list;
            PBRepeatMessageField<RecommendProxyOuterClass$KuolieRoomInfo> pBRepeatMessageField;
            l.e(b.this.TAG, "showGMChangeRoomFromFlag success");
            View view = this.f412412b.get();
            if (view != null) {
                b bVar = b.this;
                ExpandHallLaunchParam expandHallLaunchParam = this.f412413c;
                if (result != null && (pBRepeatMessageField = result.room_list) != null) {
                    list = pBRepeatMessageField.get();
                } else {
                    list = null;
                }
                if (list != null) {
                    bVar.f(view, expandHallLaunchParam, new hh4.a(hh4.a.INSTANCE.a(), list));
                }
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.e(b.this.TAG, "showGMChangeRoomFromFlag error");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"kh4/b$b", "Lkh4/e$a;", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "info", "Landroid/content/Context;", "context", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kh4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10660b implements e.a {
        C10660b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, long j3, Context context, ExpandHallLaunchParam it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(it, "$it");
            l.i(this$0.TAG, "itemClickListener " + j3 + " " + context);
            ((f) mm4.b.b(f.class)).openExpandHall(context, it);
        }

        @Override // kh4.e.a
        public void a(@NotNull RecommendProxyOuterClass$KuolieRoomInfo info, @NotNull final Context context) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(context, "context");
            final long j3 = info.room_id.get();
            ExpandHallLaunchParam expandHallLaunchParam = b.this.launchParam;
            if (expandHallLaunchParam != null) {
                expandHallLaunchParam.H = j3;
            }
            ExpandHallLaunchParam expandHallLaunchParam2 = b.this.launchParam;
            if (expandHallLaunchParam2 != null) {
                expandHallLaunchParam2.I = true;
            }
            final ExpandHallLaunchParam expandHallLaunchParam3 = b.this.launchParam;
            if (expandHallLaunchParam3 != null) {
                final b bVar = b.this;
                l.i(bVar.TAG, "itemClickListener " + j3 + " ");
                ((f) mm4.b.b(f.class)).p1();
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: kh4.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.C10660b.c(b.this, j3, context, expandHallLaunchParam3);
                    }
                }, 1000L);
            }
        }
    }

    private final void e(View view) {
        int i3;
        List<RecommendProxyOuterClass$KuolieRoomInfo> list = this.userRoomList;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            List<RecommendProxyOuterClass$KuolieRoomInfo> list2 = this.userRoomList;
            Intrinsics.checkNotNull(list2);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            e eVar = new e(list2, context);
            eVar.m0(this.itemClickListener);
            eVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.a()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.e(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    public final void d(@Nullable View changeRoomView, @NotNull ExpandHallLaunchParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        WeakReference weakReference = new WeakReference(changeRoomView);
        if (param.b(2)) {
            lh4.a.f414596a.b(new a(weakReference, param));
        }
    }

    public final void f(@Nullable View changeRoomView, @NotNull ExpandHallLaunchParam param, @Nullable hh4.a info) {
        boolean z16;
        List<RecommendProxyOuterClass$KuolieRoomInfo> list;
        int i3;
        boolean z17;
        Intrinsics.checkNotNullParameter(param, "param");
        boolean z18 = false;
        if (changeRoomView != null) {
            g.o(changeRoomView, false);
        }
        if (param.b(2)) {
            this.gmChangeRoomInfo = info;
            this.launchParam = param;
            l.i(this.TAG, "showGMChangeRoom show " + param.I);
            if (info != null) {
                z16 = info.c();
            } else {
                z16 = false;
            }
            if (info != null) {
                list = info.b();
            } else {
                list = null;
            }
            this.userRoomList = list;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (changeRoomView != null) {
                if (z16 && z17) {
                    z18 = true;
                }
                g.o(changeRoomView, z18);
            }
            if (changeRoomView != null) {
                changeRoomView.setOnClickListener(new View.OnClickListener() { // from class: kh4.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        b.g(b.this, view);
                    }
                });
            }
        }
    }

    public final void h(@Nullable View changeRoomView, @NotNull ExpandHallLaunchParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        l.i(this.TAG, "showGMChangeRoomFromFlag " + param.I);
        if (param.I) {
            d(changeRoomView, param);
        }
    }
}
