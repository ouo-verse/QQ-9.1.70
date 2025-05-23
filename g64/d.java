package g64;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.slash.businessapi.ConvertSearchTools;
import com.tencent.robot.slash.dialog.content.avatarbar.AvatarBarMsgIntent;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectMsgIntent;
import com.tencent.robot.slash.dialog.content.list.vbdelegate.coupling.SlashListCouplingEffectUIState;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListUIState;
import g64.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 9*\b\b\u0000\u0010\u0002*\u00020\u00012$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0003j\b\u0012\u0004\u0012\u00028\u0000`\u00072\u00020\b:\u0001:B\u000f\u0012\u0006\u0010.\u001a\u00020\u0006\u00a2\u0006\u0004\b8\u0010-J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0002J.\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0017*\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u001a\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001bH\u0002J\u001f\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016R\"\u0010.\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b\n\u0010-R\u0016\u00100\u001a\u00028\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00103R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u00106\u00a8\u0006;"}, d2 = {"Lg64/d;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/robot/slash/dialog/content/avatarbar/AvatarBarMsgIntent$OnClickAvatar;", "i", "", h.F, "", "titleSequenceNumber", "Lb74/a;", "itemData", HippyTKDListViewAdapter.SCROLL_STATE, "j", "", "position", "", "titleIndexArray", "Lkotlin/Pair;", "e", "itemDataList", "f", "Lv64/e;", "c", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "b", "(Lcom/tencent/mvi/api/runtime/b;Z)V", "Lcom/tencent/mvi/base/route/MsgIntent;", "call", "intent", "g", "Ljava/lang/Class;", "Lg64/b;", "d0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/robot/widget/list/vb/e;", "()Lcom/tencent/robot/widget/list/vb/e;", "(Lcom/tencent/robot/widget/list/vb/e;)V", "mHost", "Lcom/tencent/mvi/api/runtime/b;", "mContext", "Ljava/lang/Integer;", "mCurrentTitleIndex", "[I", "mCachedTitleSeqArray", "", "Ljava/util/List;", "mMessageList", "<init>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d<C extends com.tencent.mvi.api.runtime.b> implements e<com.tencent.robot.widget.list.vb.a, CommonListUIState, C, com.tencent.robot.widget.list.vb.e>, com.tencent.mvi.base.route.a {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final a f401475m = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.widget.list.vb.e mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private C mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mCurrentTitleIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] mCachedTitleSeqArray;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mMessageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lg64/d$a;", "", "", "FIRST_TITLE_POSITION", "I", "FIRST_TITLE_SEQ", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public d(@NotNull com.tencent.robot.widget.list.vb.e mHost) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{u64.c.c(Reflection.getOrCreateKotlinClass(SlashListCouplingEffectMsgIntent.ScrollToPosition.class)), u64.c.c(Reflection.getOrCreateKotlinClass(AvatarBarMsgIntent.OnClickAvatar.class)), u64.c.c(Reflection.getOrCreateKotlinClass(CommonListMsgIntent.SubmitListMsgIntent.class))});
        this.mMessageList = listOf;
    }

    private final v64.e<b74.a> c() {
        g64.a aVar = new g64.a(null);
        getMHost().fetchVBState(aVar);
        v64.e a16 = aVar.a();
        if (!(a16 instanceof v64.e)) {
            return null;
        }
        return a16;
    }

    private final Pair<Integer, b74.a> e(List<? extends b74.a> list, int i3, int[] iArr) {
        Object first;
        int b16 = n64.c.b(iArr, i3);
        if (b16 < 0) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            return TuplesKt.to(-1, first);
        }
        return TuplesKt.to(Integer.valueOf(b16), list.get(iArr[b16]));
    }

    private final int[] f(List<? extends b74.a> itemDataList) {
        if (this.mCachedTitleSeqArray == null) {
            this.mCachedTitleSeqArray = n64.c.a(itemDataList);
        }
        int[] iArr = this.mCachedTitleSeqArray;
        Intrinsics.checkNotNull(iArr);
        return iArr;
    }

    private final void h(AvatarBarMsgIntent.OnClickAvatar i3) {
        int[] iArr;
        boolean z16;
        List<b74.a> items;
        v64.e<b74.a> c16 = c();
        if (c16 != null && (items = c16.getItems()) != null) {
            iArr = f(items);
        } else {
            iArr = null;
        }
        int avatarPosition = i3.getAvatarPosition() - 1;
        if (iArr != null) {
            int i16 = 0;
            if (avatarPosition >= 0 && avatarPosition < iArr.length) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || avatarPosition == -1) {
                if (i3.getAvatarPosition() > 0) {
                    i16 = iArr[i3.getAvatarPosition() - 1];
                }
                k(new SlashListCouplingEffectUIState.ScrollToPosition(i16));
                return;
            }
        }
        QLog.e("SlashListCouplingEffectVMDelegate", 1, "titleIndexArray is null, or click position out of array bound");
    }

    private final void j(int titleSequenceNumber, b74.a itemData, int scrollState) {
        SlashTitleMsgIntent.RefreshTitle o16 = ConvertSearchTools.o(ConvertSearchTools.f368422a, itemData, 0, null, 3, null);
        C c16 = null;
        if (o16 != null) {
            C c17 = this.mContext;
            if (c17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                c17 = null;
            }
            c17.e().h(o16);
        }
        if (scrollState != 0) {
            C c18 = this.mContext;
            if (c18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                c16 = c18;
            }
            c16.e().h(new AvatarBarMsgIntent.SelectPosition(titleSequenceNumber + 1));
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull com.tencent.robot.widget.list.vb.a aVar) {
        e.a.a(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void b(@NotNull C context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        for (String str : this.mMessageList) {
            C c16 = this.mContext;
            if (c16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                c16 = null;
            }
            c16.e().d(str, this);
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof SlashListCouplingEffectMsgIntent.ScrollToPosition) {
            k(new SlashListCouplingEffectUIState.ScrollToPosition(((SlashListCouplingEffectMsgIntent.ScrollToPosition) i3).getPosition()));
        } else if (i3 instanceof AvatarBarMsgIntent.OnClickAvatar) {
            h((AvatarBarMsgIntent.OnClickAvatar) i3);
        } else if (i3 instanceof CommonListMsgIntent.SubmitListMsgIntent) {
            this.mCachedTitleSeqArray = null;
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public com.tencent.robot.widget.list.vb.e getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends com.tencent.robot.widget.list.vb.a> d0() {
        return b.class;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull com.tencent.robot.widget.list.vb.a intent) {
        v64.e<b74.a> c16;
        List<b74.a> items;
        b.a aVar;
        LinearLayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if ((intent instanceof b.a) && (c16 = c()) != null && (items = c16.getItems()) != null) {
            boolean z16 = true;
            Pair<Integer, b74.a> pair = null;
            if (!(!items.isEmpty())) {
                items = null;
            }
            if (items == null || (layoutManager = (aVar = (b.a) intent).getLayoutManager()) == null) {
                return;
            }
            Pair<Integer, b74.a> e16 = e(items, layoutManager.findFirstVisibleItemPosition(), f(items));
            int intValue = e16.getFirst().intValue();
            Integer num = this.mCurrentTitleIndex;
            if (num != null && intValue == num.intValue()) {
                z16 = false;
            }
            if (z16) {
                pair = e16;
            }
            if (pair != null) {
                this.mCurrentTitleIndex = pair.getFirst();
                j(pair.getFirst().intValue(), pair.getSecond(), aVar.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String());
            }
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.robot.widget.list.vb.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.mHost = eVar;
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void k(@NotNull CommonListUIState commonListUIState) {
        e.a.b(this, commonListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        for (String str : this.mMessageList) {
            C c16 = this.mContext;
            if (c16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                c16 = null;
            }
            c16.e().b(str, this);
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        return a.C9235a.a(this);
    }
}
