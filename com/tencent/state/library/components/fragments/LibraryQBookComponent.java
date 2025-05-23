package com.tencent.state.library.components.fragments;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.library.data.LibraryDecoratorItem;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.api.OpenHippyParams;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.template.data.CommonHippyInfo;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.EntryDecorator;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J<\u0010\u000b\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0002\b\u00030\rj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001cH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryQBookComponent;", "Lcom/tencent/state/library/components/fragments/LibraryBaseComponent;", "()V", "fastClickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "needShowQBookAvailableDialog", "", "onEnterRoom", "", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "", "data", "Lcom/tencent/state/map/MapItem;", "viewId", "extra", "", "setNeedShowQBookAvailableDialog", "show", "showQBookAvailableTip", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function0;", "showQBookDialog", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryQBookComponent extends LibraryBaseComponent {
    private static final int H5 = 2;
    private static final int HIPPY = 3;
    private static final int SCHEME = 1;
    private static final String TAG = "LibraryQBookComponent";
    private final FastClickUtils fastClickUtils = new FastClickUtils(800);

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean needShowQBookAvailableDialog() {
        return IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.KEY_Q_BOOK_AVAILABLE, true, null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNeedShowQBookAvailableDialog(boolean show) {
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.KEY_Q_BOOK_AVAILABLE, show, null, false, 12, null);
    }

    private final void showQBookDialog() {
        SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new LibraryQBookComponent$showQBookDialog$1(this));
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onEnterRoom(info);
        showQBookDialog();
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        QBaseActivity activity;
        String str;
        String domainName;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        super.onItemClicked(vh5, index, data, viewId, extra);
        if (viewId == 6 && !this.fastClickUtils.isFastDoubleClick()) {
            if (!(data instanceof LibraryDecoratorItem)) {
                data = null;
            }
            LibraryDecoratorItem libraryDecoratorItem = (LibraryDecoratorItem) data;
            Decorator decorator = libraryDecoratorItem != null ? libraryDecoratorItem.getDecorator() : null;
            if (!(decorator instanceof EntryDecorator)) {
                decorator = null;
            }
            EntryDecorator entryDecorator = (EntryDecorator) decorator;
            if (entryDecorator == null || (activity = getActivity()) == null) {
                return;
            }
            String jumpUrl = entryDecorator.getJumpUrl();
            if (jumpUrl == null || jumpUrl.length() == 0) {
                return;
            }
            int jumpType = entryDecorator.getJumpType();
            if (jumpType == 1) {
                Square.INSTANCE.getConfig().getRouter().routeLink(activity, new EntranceLink(entryDecorator.getJumpUrl(), 2));
                return;
            }
            if (jumpType == 2) {
                Square.INSTANCE.getConfig().getRouter().routeLink(activity, new EntranceLink(entryDecorator.getJumpUrl(), 1));
                return;
            }
            if (jumpType != 3) {
                return;
            }
            CommonHippyInfo hippyInfo = entryDecorator.getHippyInfo();
            String str2 = "";
            if (hippyInfo == null || (str = hippyInfo.getBundleName()) == null) {
                str = "";
            }
            CommonHippyInfo hippyInfo2 = entryDecorator.getHippyInfo();
            if (hippyInfo2 != null && (domainName = hippyInfo2.getDomainName()) != null) {
                str2 = domainName;
            }
            OpenHippyParams openHippyParams = new OpenHippyParams(str, str2, entryDecorator.getJumpUrl());
            ISquareHippyEngine hippyEngine = Square.INSTANCE.getConfig().getHippyEngine();
            VasBaseFragment parentFragment = getParentFragment();
            FragmentManager childFragmentManager = parentFragment != null ? parentFragment.getChildFragmentManager() : null;
            CommonHippyInfo hippyInfo3 = entryDecorator.getHippyInfo();
            hippyEngine.openHippyPage(activity, childFragmentManager, openHippyParams, hippyInfo3 != null ? hippyInfo3.isHalfScreen() : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showQBookAvailableTip(Context context, final Function0<Unit> callback) {
        Map<String, Object> mutableMapOf;
        if (context != null) {
            ResStyle resStyle = new ResStyle(Integer.valueOf(R.drawable.i_v), null, null, 0, 0, null, null, null, null, 510, null);
            String string = context.getString(R.string.xgc);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026library_q_boob_available)");
            CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, "\u542c\u4e66\u529f\u80fd\u4e0a\u7ebf\u5566", null, null, "\u6211\u77e5\u9053\u4e86", new ContentStyle(string, 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
            commonDialog.show();
            commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryQBookComponent$showQBookAvailableTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    Map<String, Object> mutableMapOf2;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"));
                    squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_Q_BOOK_GUIDE_DIALOG, mutableMapOf2);
                    Function0.this.invoke();
                }
            });
            IReporter squareReporter = SquareBaseKt.getSquareReporter();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
            squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_Q_BOOK_GUIDE_DIALOG, mutableMapOf);
        }
    }
}
