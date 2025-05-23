package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import c04.b;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import f04.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserAdapter extends RecyclerView.Adapter<BrowserViewHolder> {
    private static final String TAG = "BrowserAdapter";
    private boolean isFirstCome = true;
    private Context mContext;
    public MainBrowserPresenter mainBrowserPresenter;
    int margin;
    int screenHeight;
    int screenWidth;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class BrowserViewHolder extends RecyclerView.ViewHolder {
        public b decoratorPresenter;
        public c itemView;
        public f04.b presenterBuilder;

        public BrowserViewHolder(BrowserBaseView browserBaseView, b bVar, f04.b bVar2) {
            super(browserBaseView.mBrowserItemView);
            this.itemView = browserBaseView;
            this.decoratorPresenter = bVar;
            this.presenterBuilder = bVar2;
        }
    }

    public BrowserAdapter(Context context) {
        this.mContext = context;
        this.margin = ScreenUtils.dip2px(context, 0.0f);
        this.screenWidth = ScreenUtils.getScreenWidth(this.mContext);
        this.screenHeight = ScreenUtils.getScreenHeight(this.mContext);
    }

    private void setParams(View view, int i3) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (i3 != 0 && i3 != getNUM_BACKGOURND_ICON() - 1) {
            int i16 = this.margin;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i16;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i16;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).width = this.screenWidth;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = this.screenHeight;
        view.setLayoutParams(layoutParams);
    }

    public RichMediaBrowserInfo getItem(int i3) {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserModel = mainBrowserPresenter.browserModel) != null) {
            return mainBrowserModel.getItem(i3);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        MainBrowserModel mainBrowserModel;
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserModel = mainBrowserPresenter.browserModel) != null) {
            return mainBrowserModel.getCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo item = getItem(i3);
        if (item != null && (richMediaBaseData = item.baseData) != null) {
            return richMediaBaseData.getType();
        }
        return super.getItemViewType(i3);
    }

    public void reset() {
        this.isFirstCome = true;
    }

    public void setPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.mainBrowserPresenter = mainBrowserPresenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BrowserViewHolder browserViewHolder, int i3) {
        BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "onBindViewHolder position = " + i3);
        if (browserViewHolder != null) {
            c cVar = browserViewHolder.itemView;
            if (cVar instanceof BrowserBaseView) {
                BrowserBaseView browserBaseView = (BrowserBaseView) cVar;
                browserBaseView.bindView(i3);
                if (this.isFirstCome) {
                    this.isFirstCome = false;
                    this.mainBrowserPresenter.onItemSelect(i3);
                    browserBaseView.onItemSelected(i3);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BrowserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        BrowserBaseView browserBaseView;
        BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "onCreateViewHolder  viewType = " + i3);
        c buildItemView = this.mainBrowserPresenter.buildItemView(i3);
        if (buildItemView instanceof BrowserBaseView) {
            browserBaseView = (BrowserBaseView) buildItemView;
            browserBaseView.getView(browserBaseView.mBrowserItemView, viewGroup);
            if (browserBaseView.mBrowserItemView != null) {
                return new BrowserViewHolder(browserBaseView, this.mainBrowserPresenter.getDecoratorPresenter(i3), this.mainBrowserPresenter.getPresenter(i3));
            }
        } else {
            BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "onCreateViewHolder  baseView is null");
            browserBaseView = new BrowserBaseView(this.mContext, new BrowserBasePresenter());
            browserBaseView.mBrowserItemView = new RelativeLayout(this.mContext);
        }
        return new BrowserViewHolder(browserBaseView, this.mainBrowserPresenter.getDecoratorPresenter(i3), this.mainBrowserPresenter.getPresenter(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(BrowserViewHolder browserViewHolder) {
        MainBrowserPresenter mainBrowserPresenter;
        MainBrowserScene mainBrowserScene;
        super.onViewRecycled((BrowserAdapter) browserViewHolder);
        c cVar = browserViewHolder.itemView;
        if (!(cVar instanceof BrowserBaseView) || (mainBrowserPresenter = this.mainBrowserPresenter) == null || (mainBrowserScene = mainBrowserPresenter.browserScene) == null) {
            return;
        }
        BrowserBaseView browserBaseView = (BrowserBaseView) cVar;
        int position = mainBrowserScene.getPosition(browserBaseView.mBrowserItemView);
        BrowserLogHelper.getInstance().getGalleryLog().i(TAG, 2, "onViewRecycled position = " + position);
        browserBaseView.onDestroyView(position, browserBaseView.mBrowserItemView);
    }
}
