package com.tencent.mobileqq.minigame.publicaccount.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy2;
import com.tencent.mobileqq.minigame.publicaccount.view.GameArkView;
import com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WebUiStrategy2HeaderAdapter extends BaseHeaderAdapter implements GameArkView.LoadGameArkCallback {
    private static final String TAG = "WebUiStrategy2HeaderAdapter";

    public WebUiStrategy2HeaderAdapter(Activity activity) {
        super(activity);
    }

    private void insertArkTime(QQGameMsgInfo qQGameMsgInfo) {
        try {
            long optLong = new JSONObject(qQGameMsgInfo.arkAppConfig).optLong("ctime", -1L);
            if (optLong != -1) {
                JSONObject jSONObject = new JSONObject(qQGameMsgInfo.arkMetaList);
                JSONObject optJSONObject = jSONObject.optJSONObject("qqgame_model");
                if (optJSONObject != null) {
                    optJSONObject.put("msgTime", optLong);
                }
                qQGameMsgInfo.arkMetaList = jSONObject.toString();
            }
        } catch (JSONException e16) {
            QLog.w(TAG, 1, "insertArkTime fail:", e16);
        }
    }

    private void modifyArkViewLayout(GameArkView gameArkView, ViewGroup viewGroup, int i3) {
        gameArkView.setLoadCallback(this);
        viewGroup.addView(gameArkView, new RelativeLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) gameArkView.getArkView().getLayoutParams();
        layoutParams.width = WebUiStrategy2.Strategy2Config.arkViewWidth;
        layoutParams.height = WebUiStrategy2.Strategy2Config.viewPagerItemHeight;
        layoutParams.leftMargin = WebUiStrategy2.Strategy2Config.viewPagerItemMarginLeft;
        layoutParams.gravity = 3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int i3) {
        return WebUiStrategy2.Strategy2Config.viewPagerWidth;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        List<QQGameMsgInfo> list = this.mMsgInfoList;
        if (list != null && list.size() != 0) {
            Object obj = (IHeaderView) this.mHeaderRecords.get(i3);
            if (obj == null) {
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.d(TAG, 2, "headerView = null");
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "headerView = " + obj.getClass().getSimpleName());
            }
            View view = (View) obj;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (obj instanceof GameArkView) {
                modifyArkViewLayout((GameArkView) obj, viewGroup, i3);
            } else {
                viewGroup.addView(view, new RelativeLayout.LayoutParams(-2, -2));
            }
            if (i3 == 0) {
                initArk(0);
            }
            return obj;
        }
        View createEmptyView = createEmptyView();
        viewGroup.addView(createEmptyView);
        return createEmptyView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter
    public void setData(List<QQGameMsgInfo> list) {
        if (list != null) {
            Iterator<QQGameMsgInfo> it = list.iterator();
            while (it.hasNext()) {
                insertArkTime(it.next());
            }
        }
        super.setData(list);
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.view.GameArkView.LoadGameArkCallback
    public void onLoadFinish(int i3, int i16) {
        if (i3 == 1) {
            initArk(i16 + 1);
        }
    }
}
