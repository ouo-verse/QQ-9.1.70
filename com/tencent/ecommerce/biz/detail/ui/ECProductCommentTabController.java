package com.tencent.ecommerce.biz.detail.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.tabbar.ECTabCoverInfo;
import com.tencent.ecommerce.base.ui.tabbar.ECTabLayout;
import com.tencent.ecommerce.biz.detail.ProductCommentSortType;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0002\u000e(B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u0012\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController;", "", "", "k", "i", "Lcom/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController$OnSortTypeChangedListener;", "listener", "j", "", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "a", "Ljava/util/List;", "tabCoverInfoList", "", "b", "I", "currentTabPos", "c", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "currentTab", "d", "getCurrentSortType$annotations", "()V", "currentSortType", "e", "Lcom/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController$OnSortTypeChangedListener;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "g", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;", "tabLayout", "", h.F, "Ljava/lang/String;", "spuId", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout;Ljava/lang/String;)V", "OnSortTypeChangedListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductCommentTabController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<ECTabCoverInfo> tabCoverInfoList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentTabPos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ECTabCoverInfo currentTab;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentSortType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private OnSortTypeChangedListener listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ECTabLayout tabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String spuId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController$OnSortTypeChangedListener;", "", "onSortTypeChanged", "", "sortType", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface OnSortTypeChangedListener {
        void onSortTypeChanged(@ProductCommentSortType int sortType);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/detail/ui/ECProductCommentTabController$a", "Lcom/tencent/ecommerce/base/ui/tabbar/ECTabLayout$OnTabClickListener;", "Lcom/tencent/ecommerce/base/ui/tabbar/a;", "data", "", "position", "", "onTabClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements ECTabLayout.OnTabClickListener {
        a() {
        }

        @Override // com.tencent.ecommerce.base.ui.tabbar.ECTabLayout.OnTabClickListener
        public void onTabClick(ECTabCoverInfo data, int position) {
            int i3 = data.tabId;
            int i16 = 1;
            if (i3 == 1) {
                com.tencent.ecommerce.biz.detail.utils.d.f102466a.e(1, ECProductCommentTabController.this.spuId);
            } else if (i3 == 2) {
                com.tencent.ecommerce.biz.detail.utils.d.f102466a.e(2, ECProductCommentTabController.this.spuId);
                i16 = 2;
            } else if (i3 == 3) {
                ECTabCoverInfo eCTabCoverInfo = ECProductCommentTabController.this.currentTab;
                i16 = 4;
                if (eCTabCoverInfo != null && eCTabCoverInfo.tabId == 3 && ECProductCommentTabController.this.currentSortType == 4) {
                    i16 = 3;
                }
                com.tencent.ecommerce.biz.detail.utils.d.f102466a.e(3, ECProductCommentTabController.this.spuId);
            }
            if (i16 == ECProductCommentTabController.this.currentSortType) {
                return;
            }
            ECProductCommentTabController.this.currentSortType = i16;
            ECProductCommentTabController.this.currentTab = data;
            ECProductCommentTabController.this.currentTabPos = position;
            ECProductCommentTabController.this.k();
            OnSortTypeChangedListener onSortTypeChangedListener = ECProductCommentTabController.this.listener;
            if (onSortTypeChangedListener != null) {
                onSortTypeChangedListener.onSortTypeChanged(ECProductCommentTabController.this.currentSortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        int size = this.tabCoverInfoList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            View h16 = this.tabLayout.h(i3);
            TextView textView = h16 != null ? (TextView) h16.findViewById(R.id.oer) : null;
            if (i3 == this.currentTabPos) {
                if (textView != null) {
                    textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6952y));
                }
                if (textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
            } else {
                if (textView != null) {
                    textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
                }
                if (textView != null) {
                    textView.setTypeface(Typeface.defaultFromStyle(0));
                }
            }
            i3++;
        }
        View h17 = this.tabLayout.h(2);
        ImageView imageView = h17 != null ? (ImageView) h17.findViewById(R.id.o1y) : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        int i16 = this.currentSortType;
        if (i16 == 3) {
            if (imageView != null) {
                imageView.setImageDrawable(this.context.getDrawable(R.drawable.f159681bk4));
            }
        } else if (i16 != 4) {
            if (imageView != null) {
                imageView.setImageDrawable(this.context.getDrawable(R.drawable.bk5));
            }
        } else if (imageView != null) {
            imageView.setImageDrawable(this.context.getDrawable(R.drawable.bk6));
        }
    }

    public final void i() {
        this.tabLayout.x(this.tabCoverInfoList);
        this.tabLayout.t(0);
        k();
    }

    public final void j(OnSortTypeChangedListener listener) {
        this.listener = listener;
    }

    public ECProductCommentTabController(Context context, ECTabLayout eCTabLayout, String str) {
        this.context = context;
        this.tabLayout = eCTabLayout;
        this.spuId = str;
        ArrayList arrayList = new ArrayList();
        this.tabCoverInfoList = arrayList;
        this.currentSortType = 1;
        ECSkin eCSkin = ECSkin.INSTANCE;
        arrayList.add(new ECTabCoverInfo(1, "\u7efc\u5408", "TAB_IDENTIFIER_SORT_GENERAL", R.layout.ct6, 0.0f, eCSkin.getColor(R.color.f6952y), false, 0, 208, null));
        arrayList.add(new ECTabCoverInfo(2, "\u6700\u65b0", "TAB_IDENTIFIER_SORT_TIME", R.layout.ct6, 0.0f, eCSkin.getColor(R.color.f6952y), false, 0, 208, null));
        arrayList.add(new ECTabCoverInfo(3, "\u8bc4\u5206", "TAB_IDENTIFIER_SORT_SCORE", R.layout.ct6, 0.0f, eCSkin.getColor(R.color.f6952y), false, 0, 208, null));
        eCTabLayout.setOnTabClickListener(new a());
    }
}
