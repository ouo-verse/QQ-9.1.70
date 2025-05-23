package com.tencent.mobileqq.troop.file.search.fragment;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.s;
import com.tencent.mobileqq.troop.file.search.vm.TroopFileSearchByTypeVM;
import com.tencent.mobileqq.troop.file.search.vm.a;
import com.tencent.mobileqq.troop.file.search.vm.b;
import com.tencent.mobileqq.troop.file.widget.TroopFileViewMoreRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ls2.b;
import ls2.c;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J(\u0010 \u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016R#\u0010'\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u0014\u0010G\u001a\u00020D8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/fragment/TroopFileSearchByTypeFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lls2/a;", "", "Ah", "initUI", "", "id", "Landroid/view/View;", "findViewById", "", "loadingOver", "Ch", "bizId", "Dh", "Lcom/tencent/mobileqq/troop/data/s;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Eh", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "fileId", WadlProxyConsts.PARAM_FILENAME, "busId", "thumbnailSizeSmall", "S4", "Lcom/tencent/mobileqq/troop/file/search/vm/TroopFileSearchByTypeVM;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/troop/file/search/vm/TroopFileSearchByTypeVM;", "viewModel", "Lcom/tencent/widget/XListView;", "D", "Lcom/tencent/widget/XListView;", "listView", "Lcom/tencent/mobileqq/troop/file/widget/TroopFileViewMoreRelativeLayout;", "E", "Lcom/tencent/mobileqq/troop/file/widget/TroopFileViewMoreRelativeLayout;", "listFooter", "Lls2/b;", UserInfo.SEX_FEMALE, "Lls2/b;", "adapter", "G", "Landroid/view/View;", "businessView", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "businessIv", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "businessTv", "J", "Ljava/lang/String;", "titleStr", "K", "toastOffset", "", "yh", "()J", "troopUin", "xh", "()I", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "<init>", "()V", "L", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileSearchByTypeFragment extends QIphoneTitleBarFragment implements ls2.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private XListView listView;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopFileViewMoreRelativeLayout listFooter;

    /* renamed from: F, reason: from kotlin metadata */
    private b adapter;

    /* renamed from: G, reason: from kotlin metadata */
    private View businessView;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView businessIv;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView businessTv;

    /* renamed from: J, reason: from kotlin metadata */
    private String titleStr;

    /* renamed from: K, reason: from kotlin metadata */
    private int toastOffset;

    public TroopFileSearchByTypeFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileSearchByTypeVM>() { // from class: com.tencent.mobileqq.troop.file.search.fragment.TroopFileSearchByTypeFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileSearchByTypeVM invoke() {
                TroopFileSearchByTypeVM troopFileSearchByTypeVM = (TroopFileSearchByTypeVM) TroopFileSearchByTypeFragment.this.getViewModel(TroopFileSearchByTypeVM.class);
                Bundle requireArguments = TroopFileSearchByTypeFragment.this.requireArguments();
                Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
                troopFileSearchByTypeVM.init(requireArguments);
                return troopFileSearchByTypeVM;
            }
        });
        this.viewModel = lazy;
        this.titleStr = "";
    }

    private final void Ah() {
        MutableLiveData<com.tencent.mobileqq.troop.file.search.vm.a> obtainUiState = zh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.file.search.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.file.search.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.file.search.fragment.TroopFileSearchByTypeFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.file.search.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.file.search.vm.a aVar) {
                b bVar;
                b bVar2;
                TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout;
                int i3;
                if (aVar instanceof a.d) {
                    TroopFileSearchByTypeFragment.this.Dh(((a.d) aVar).getBusId());
                    return;
                }
                if (aVar instanceof a.c) {
                    a.c cVar = (a.c) aVar;
                    QQToast makeText = QQToast.makeText(TroopFileSearchByTypeFragment.this.getContext(), cVar.getType(), cVar.getMsg(), 0);
                    i3 = TroopFileSearchByTypeFragment.this.toastOffset;
                    makeText.show(i3);
                    return;
                }
                b bVar3 = null;
                TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout2 = null;
                if (aVar instanceof a.f) {
                    troopFileViewMoreRelativeLayout = TroopFileSearchByTypeFragment.this.listFooter;
                    if (troopFileViewMoreRelativeLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listFooter");
                    } else {
                        troopFileViewMoreRelativeLayout2 = troopFileViewMoreRelativeLayout;
                    }
                    troopFileViewMoreRelativeLayout2.setVisibility(((a.f) aVar).getVisibility());
                    return;
                }
                if (aVar instanceof a.b) {
                    TroopFileSearchByTypeFragment.this.Ch(((a.b) aVar).getLoadOver());
                    return;
                }
                if (aVar instanceof a.e) {
                    TroopFileSearchByTypeFragment.this.Eh(((a.e) aVar).getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String());
                    return;
                }
                if (aVar instanceof a.C8686a) {
                    a.C8686a c8686a = (a.C8686a) aVar;
                    if (c8686a.getMsg() == 0) {
                        TroopFileSearchByTypeFragment.this.Dh(0);
                        return;
                    }
                    if (c8686a.getMsg() != 1 || c8686a.getCom.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes.DbCassandraConsistencyLevelValues.ANY java.lang.String() == null) {
                        return;
                    }
                    TroopFileSearchByTypeFragment.this.Dh(3);
                    bVar = TroopFileSearchByTypeFragment.this.adapter;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        bVar = null;
                    }
                    Object obj = c8686a.getCom.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes.DbCassandraConsistencyLevelValues.ANY java.lang.String();
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mobileqq.troop.data.TroopFileSearchByTypeItemData>");
                    bVar.a(TypeIntrinsics.asMutableList(obj));
                    bVar2 = TroopFileSearchByTypeFragment.this.adapter;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        bVar3 = bVar2;
                    }
                    bVar3.notifyDataSetChanged();
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.file.search.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFileSearchByTypeFragment.Bh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ch(boolean loadingOver) {
        XListView xListView = this.listView;
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout = null;
        if (xListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            xListView = null;
        }
        if (xListView.getFirstVisiblePosition() == 0) {
            TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout2 = this.listFooter;
            if (troopFileViewMoreRelativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            } else {
                troopFileViewMoreRelativeLayout = troopFileViewMoreRelativeLayout2;
            }
            troopFileViewMoreRelativeLayout.setVisibility(8);
            return;
        }
        if (loadingOver) {
            TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout3 = this.listFooter;
            if (troopFileViewMoreRelativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            } else {
                troopFileViewMoreRelativeLayout = troopFileViewMoreRelativeLayout3;
            }
            troopFileViewMoreRelativeLayout.setVisibility(8);
            return;
        }
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout4 = this.listFooter;
        if (troopFileViewMoreRelativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            troopFileViewMoreRelativeLayout4 = null;
        }
        troopFileViewMoreRelativeLayout4.setVisibility(0);
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout5 = this.listFooter;
        if (troopFileViewMoreRelativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            troopFileViewMoreRelativeLayout5 = null;
        }
        troopFileViewMoreRelativeLayout5.setText(R.string.cuy);
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout6 = this.listFooter;
        if (troopFileViewMoreRelativeLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFooter");
        } else {
            troopFileViewMoreRelativeLayout = troopFileViewMoreRelativeLayout6;
        }
        troopFileViewMoreRelativeLayout.setTextLeftDrawable(R.drawable.f160545jt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v30, types: [com.tencent.mobileqq.troop.file.widget.TroopFileViewMoreRelativeLayout] */
    /* JADX WARN: Type inference failed for: r11v39, types: [android.view.View] */
    public final void Dh(int bizId) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = BaseAIOUtils.f(320.0f, resources);
        obtain.mRequestHeight = BaseAIOUtils.f(200.0f, resources);
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable("https://hb.url.cn/myapp/qq_desk/chatfileEmptyImage.png", obtain);
        TextView textView = null;
        if (bizId == 0) {
            XListView xListView = this.listView;
            if (xListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                xListView = null;
            }
            xListView.setVisibility(4);
            View view = this.businessView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessView");
                view = null;
            }
            view.setVisibility(0);
            ImageView imageView = this.businessIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessIv");
                imageView = null;
            }
            imageView.setImageDrawable(drawable2);
            TextView textView2 = this.businessTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessTv");
            } else {
                textView = textView2;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.eux);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_tr\u2026p_search_no_file_by_type)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.titleStr}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            return;
        }
        if (bizId == 1) {
            XListView xListView2 = this.listView;
            if (xListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                xListView2 = null;
            }
            xListView2.setVisibility(4);
            View view2 = this.businessView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessView");
                view2 = null;
            }
            view2.setVisibility(0);
            ImageView imageView2 = this.businessIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessIv");
                imageView2 = null;
            }
            imageView2.setImageDrawable(drawable2);
            TextView textView3 = this.businessTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessTv");
            } else {
                textView = textView3;
            }
            textView.setText(R.string.eq8);
            return;
        }
        if (bizId == 2) {
            XListView xListView3 = this.listView;
            if (xListView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                xListView3 = null;
            }
            xListView3.setVisibility(0);
            View view3 = this.businessView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("businessView");
                view3 = null;
            }
            view3.setVisibility(4);
            ?? r112 = this.listFooter;
            if (r112 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            } else {
                textView = r112;
            }
            textView.setVisibility(8);
            QQToast.makeText(getActivity(), 1, HardCodeUtil.qqStr(R.string.f172814uf2), 0).show(this.toastOffset);
            return;
        }
        if (bizId == 3) {
            XListView xListView4 = this.listView;
            if (xListView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                xListView4 = null;
            }
            xListView4.setVisibility(0);
            ?? r113 = this.businessView;
            if (r113 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("businessView");
            } else {
                textView = r113;
            }
            textView.setVisibility(4);
            return;
        }
        if (bizId != 4) {
            return;
        }
        XListView xListView5 = this.listView;
        if (xListView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            xListView5 = null;
        }
        xListView5.setVisibility(4);
        View view4 = this.businessView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessView");
            view4 = null;
        }
        view4.setVisibility(0);
        ImageView imageView3 = this.businessIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessIv");
            imageView3 = null;
        }
        imageView3.setImageDrawable(drawable2);
        TextView textView4 = this.businessTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("businessTv");
        } else {
            textView = textView4;
        }
        textView.setText(R.string.cuy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(s item) {
        XListView xListView = this.listView;
        if (xListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            xListView = null;
        }
        int childCount = xListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            XListView xListView2 = this.listView;
            if (xListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                xListView2 = null;
            }
            View childAt = xListView2.getChildAt(i3);
            if (childAt == null) {
                return;
            }
            Object tag = childAt.getTag();
            c cVar = tag instanceof c ? (c) tag : null;
            if (cVar != null) {
                Object tag2 = cVar.getLayout().getTag(R.id.giu);
                Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.tencent.mobileqq.troop.data.TroopFileSearchByTypeItemData");
                s sVar = (s) tag2;
                if (TextUtils.equals(sVar.f294966i.f294916b, item.f294966i.f294916b)) {
                    sVar.f294966i.f294937w = item.f294966i.f294937w;
                    AsyncImageView fileIconIv = cVar.getFileIconIv();
                    n nVar = item.f294966i;
                    Intrinsics.checkNotNullExpressionValue(nVar, "item.mFileInfo");
                    cVar.d(fileIconIv, nVar);
                    return;
                }
            }
        }
    }

    private final View findViewById(int id5) {
        View findViewById = requireView().findViewById(id5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "requireView().findViewById(id)");
        return findViewById;
    }

    private final int xh() {
        return zh().Q1().a();
    }

    private final long yh() {
        return zh().Q1().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopFileSearchByTypeVM zh() {
        return (TroopFileSearchByTypeVM) this.viewModel.getValue();
    }

    @Override // ls2.a
    public void S4(String fileId, String fileName, int busId, int thumbnailSizeSmall) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopFileSearchByTypeFragment$fetchThumbnail$1(this, new b.a(fileId, fileName, busId, thumbnailSizeSmall), null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ai5;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI();
        Ah();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopFileSearchByTypeFragment$onViewCreated$1(this, null), 3, null);
    }

    private final void initUI() {
        String string;
        this.businessView = findViewById(R.id.git);
        View findViewById = findViewById(R.id.gid);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.businessIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.gig);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.businessTv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.search_result_list);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.widget.XListView");
        this.listView = (XListView) findViewById3;
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout = new TroopFileViewMoreRelativeLayout(getContext());
        this.listFooter = troopFileViewMoreRelativeLayout;
        troopFileViewMoreRelativeLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout2 = this.listFooter;
        XListView xListView = null;
        if (troopFileViewMoreRelativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            troopFileViewMoreRelativeLayout2 = null;
        }
        troopFileViewMoreRelativeLayout2.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout3 = this.listFooter;
        if (troopFileViewMoreRelativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            troopFileViewMoreRelativeLayout3 = null;
        }
        troopFileViewMoreRelativeLayout3.setVisibility(8);
        this.adapter = new ls2.b(zh().Q1().b(), yh(), this);
        XListView xListView2 = this.listView;
        if (xListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            xListView2 = null;
        }
        TroopFileViewMoreRelativeLayout troopFileViewMoreRelativeLayout4 = this.listFooter;
        if (troopFileViewMoreRelativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFooter");
            troopFileViewMoreRelativeLayout4 = null;
        }
        xListView2.addFooterView(troopFileViewMoreRelativeLayout4);
        XListView xListView3 = this.listView;
        if (xListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            xListView3 = null;
        }
        ls2.b bVar = this.adapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            bVar = null;
        }
        xListView3.setAdapter((ListAdapter) bVar);
        this.toastOffset = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        XListView xListView4 = this.listView;
        if (xListView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
        } else {
            xListView = xListView4;
        }
        xListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.tencent.mobileqq.troop.file.search.fragment.TroopFileSearchByTypeFragment$initUI$1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private int lastVisibleIndex;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private int totalItemCount;

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.totalItemCount = totalItemCount;
                this.lastVisibleIndex = ((firstVisibleItem + visibleItemCount) - 1) - 1;
            }

            @Override // com.tencent.widget.AbsListView.OnScrollListener
            public synchronized void onScrollStateChanged(AbsListView view, int scrollState) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (scrollState == 0 && this.lastVisibleIndex == this.totalItemCount - 2) {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(TroopFileSearchByTypeFragment.this), null, null, new TroopFileSearchByTypeFragment$initUI$1$onScrollStateChanged$1(TroopFileSearchByTypeFragment.this, null), 3, null);
                }
            }
        });
        int xh5 = xh();
        if (xh5 == 1) {
            string = getString(R.string.elg);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_troop_file_type_doc)");
        } else if (xh5 == 2) {
            string = getString(R.string.ell);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_troop_file_type_video)");
        } else if (xh5 == 3) {
            string = getString(R.string.elj);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_troop_file_type_music)");
        } else if (xh5 == 4) {
            string = getString(R.string.elh);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_troop_file_type_image)");
        } else if (xh5 != 10000) {
            string = "";
        } else {
            string = getString(R.string.elk);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qb_troop_file_type_others)");
        }
        this.titleStr = string;
        setTitle(string);
    }
}
