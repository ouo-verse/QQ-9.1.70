package cooperation.qqfav.globalsearch;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import qn2.d;
import sn2.g;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FavoriteSearchFragment extends BaseSearchFragment<b> {
    private pn2.a C;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class a extends mn2.b<y, sn2.c> implements View.OnClickListener {
        public a(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        @Override // mn2.a
        protected d<y, sn2.c> e(int i3) {
            return new c(((BaseSearchFragment) FavoriteSearchFragment.this).faceDecoder);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new g(viewGroup, R.layout.bxp);
        }

        @Override // mn2.a, android.widget.Adapter
        public int getCount() {
            b bVar;
            int count = super.getCount();
            if (count > 0 && (bVar = (b) super.getItem(count - 1)) != null && bVar.G == -2) {
                return count - 1;
            }
            return count;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            if (i3 == super.getCount() - 1) {
                return 1;
            }
            return 0;
        }

        @Override // mn2.a, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            TextView textView;
            if (getItemViewType(i3) == 1) {
                if (view == null) {
                    textView = new TextView(viewGroup.getContext());
                    textView.setTextSize(18.0f);
                    textView.setTextColor(viewGroup.getResources().getColor(R.color.skin_blue_item));
                    textView.setGravity(1);
                    textView.setClickable(true);
                    textView.setOnClickListener(this);
                    textView.setPadding(0, 16, 0, 16);
                    view2 = textView;
                } else {
                    view2 = view;
                    textView = (TextView) view;
                }
                b bVar = (b) super.getItem(i3);
                if (bVar != null && bVar.G == -1) {
                    textView.performClick();
                } else {
                    textView.setText(R.string.eyy);
                    Animatable animatable = (Animatable) textView.getCompoundDrawables()[1];
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    if (animatable != null) {
                        animatable.stop();
                    }
                }
                view3 = view2;
            } else {
                view2 = super.getView(i3, view, viewGroup);
                view3 = view;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TextView textView = (TextView) view;
            textView.setText((CharSequence) null);
            Animatable animatable = (Animatable) BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.f160545jt);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) animatable, (Drawable) null, (Drawable) null);
            animatable.start();
            FavoriteSearchFragment favoriteSearchFragment = FavoriteSearchFragment.this;
            FavoriteSearchEngine favoriteSearchEngine = (FavoriteSearchEngine) favoriteSearchFragment.searchEngine;
            favoriteSearchFragment.C.f426495a = FavoriteSearchFragment.this.keyword;
            favoriteSearchEngine.c(FavoriteSearchFragment.this.C, FavoriteSearchFragment.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getHeaderText() {
        return do2.d.D;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return HardCodeUtil.qqStr(R.string.jzr);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected int getSearchModule() {
        return 60;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a<y, sn2.c> newAdapter() {
        return new a(this.listView, this.faceDecoder);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b<b> newSearchEngine() {
        return new FavoriteSearchEngine((QQAppInterface) this.appInterface);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("bMore", true);
        bundle2.putBoolean("bSearchNet", true);
        bundle2.putInt("iNumber", 12);
        this.C = new pn2.a(this.keyword, bundle2);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void startSearch(String str) {
        showNoMoreResult(false);
        if (!TextUtils.isEmpty(str)) {
            this.keyword = str;
        } else if (this.searchEngine != null && this.listView != null) {
            this.adapter.g(null);
            this.footerLoadingView.setVisibility(8);
            this.centerLoadingLayout.setVisibility(8);
            this.headerLayout.setVisibility(8);
            this.searchEngine.cancel();
            showNoResultLayout(false);
            showNoMoreResult(false);
            removeAllMessage();
            return;
        }
        on2.b bVar = this.searchEngine;
        if (bVar != null && this.listView != null) {
            bVar.cancel();
            FavoriteSearchEngine favoriteSearchEngine = (FavoriteSearchEngine) this.searchEngine;
            pn2.a aVar = this.C;
            aVar.f426495a = str;
            favoriteSearchEngine.c(aVar, this);
            this.searchTimes++;
        }
    }
}
