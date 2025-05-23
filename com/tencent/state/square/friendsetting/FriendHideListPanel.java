package com.tencent.state.square.friendsetting;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.IFaceDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ls4.c;
import ls4.f;
import wx4.d;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0006H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/friendsetting/FriendHideListPanel;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "pageInfo", "", "", "", "(Landroid/content/Context;Ljava/util/Map;)V", "adapter", "Lcom/tencent/state/square/friendsetting/HideListAdapter;", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "cancelHideCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uin", "", "getCancelHideCallback", "()Lkotlin/jvm/functions/Function1;", "setCancelHideCallback", "(Lkotlin/jvm/functions/Function1;)V", "emptyView", "Landroid/view/View;", "listView", "Landroidx/recyclerview/widget/RecyclerView;", "reporter", "Lcom/tencent/state/square/IReporter;", "dismiss", "initData", "initRecycle", "initWindow", "reportImp", "value", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FriendHideListPanel extends Dialog {
    private static final String TAG = "FriendHideListPanel";
    private final HideListAdapter adapter;
    private final IFaceDecoder avatarFaceDecoder;
    private Function1<? super String, Unit> cancelHideCallback;
    private final View emptyView;
    private final RecyclerView listView;
    private IReporter reporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendHideListPanel(Context context, Map<String, Object> pageInfo) {
        super(context, R.style.f243250a);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        IFaceDecoder faceDecoder = Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.avatarFaceDecoder = faceDecoder;
        this.adapter = new HideListAdapter(faceDecoder);
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        setContentView(R.layout.d4z);
        View findViewById = findViewById(R.id.q5l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.listView = recyclerView;
        View findViewById2 = findViewById(R.id.prf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.empty)");
        this.emptyView = findViewById2;
        initWindow();
        initRecycle();
        IReporter iReporter = this.reporter;
        View findViewById3 = findViewById(R.id.qin);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.root)");
        iReporter.setPageInfo(this, findViewById3, SquareReportConst.PageId.PAGE_ID_HOST_DETAIL, pageInfo);
        this.reporter.setElementInfo(recyclerView, SquareReportConst.ElementId.ELEMENT_ID_HIDE_MANAGER, new LinkedHashMap(), false, false);
    }

    private final void initData() {
        FriendHideListDataManager.getHideList$default(FriendHideListDataManager.INSTANCE, 0, 0L, false, new Function1<c, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendHideListPanel$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(c cVar) {
                View view;
                List<f> list;
                HideListAdapter hideListAdapter;
                View view2;
                View view3;
                if (cVar == null) {
                    view3 = FriendHideListPanel.this.emptyView;
                    view3.setVisibility(0);
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FriendHideListPanel", "getHideList error", null, 4, null);
                    FriendHideListPanel.this.reportImp("0");
                    return;
                }
                f[] fVarArr = cVar.f415518a;
                if (fVarArr != null) {
                    if (!(fVarArr.length == 0)) {
                        if (FriendHideListPanel.this.isShowing()) {
                            list = ArraysKt___ArraysKt.toList(fVarArr);
                            if (list.isEmpty()) {
                                view2 = FriendHideListPanel.this.emptyView;
                                view2.setVisibility(0);
                                FriendHideListPanel.this.reportImp("0");
                                return;
                            } else {
                                FriendHideListPanel.this.reportImp("1");
                                hideListAdapter = FriendHideListPanel.this.adapter;
                                hideListAdapter.setData(list);
                                return;
                            }
                        }
                        return;
                    }
                }
                view = FriendHideListPanel.this.emptyView;
                view.setVisibility(0);
                SquareBaseKt.getSquareLog().w("FriendHideListPanel", "getHideList data is empty");
                FriendHideListPanel.this.reportImp("0");
            }
        }, 7, null);
    }

    private final void initRecycle() {
        this.listView.setAdapter(this.adapter);
        this.listView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.adapter.setOnItemCancelClickListener(new Function1<f, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendHideListPanel$initRecycle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(f fVar) {
                invoke2(fVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final f it) {
                HideListAdapter hideListAdapter;
                View view;
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<String, Unit> cancelHideCallback = FriendHideListPanel.this.getCancelHideCallback();
                if (cancelHideCallback != null) {
                    cancelHideCallback.invoke(String.valueOf(it.f415524a));
                }
                hideListAdapter = FriendHideListPanel.this.adapter;
                if (hideListAdapter.getNUM_BACKGOURND_ICON() == 0) {
                    view = FriendHideListPanel.this.emptyView;
                    view.setVisibility(0);
                }
                ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                Context context = FriendHideListPanel.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                commonUtils.showToast(context, R.string.xcc, 2);
                FriendHideListDataManager.INSTANCE.cancelHide(it.f415524a, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendHideListPanel$initRecycle$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, int i3) {
                        SquareBaseKt.getSquareLog().i("FriendHideListPanel", "cancel hide " + f.this.f415524a + " result " + z16);
                        FriendHideListDataManager.INSTANCE.getService().report(SquareReportConst.CustomEventId.EVENT_ID_HIDE_FRIEND, String.valueOf(f.this.f415524a), 0, d.INSTANCE.b(z16), i3, "em_hide_friend_manage");
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportImp(String value) {
        IReporter iReporter = this.reporter;
        RecyclerView recyclerView = this.listView;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_HAS_FRIEND, value);
        Unit unit = Unit.INSTANCE;
        iReporter.reportEvent("imp", recyclerView, linkedHashMap);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.avatarFaceDecoder.destroy();
    }

    public final Function1<String, Unit> getCancelHideCallback() {
        return this.cancelHideCallback;
    }

    public final void setCancelHideCallback(Function1<? super String, Unit> function1) {
        this.cancelHideCallback = function1;
    }

    private final void initWindow() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setLayout(SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null), -2);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R.style.f243260b);
        }
    }
}
