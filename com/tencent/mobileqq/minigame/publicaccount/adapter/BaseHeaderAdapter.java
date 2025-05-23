package com.tencent.mobileqq.minigame.publicaccount.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountConst;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.minigame.publicaccount.view.GameArkView;
import com.tencent.mobileqq.minigame.publicaccount.view.IHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class BaseHeaderAdapter extends PagerAdapter {
    private static final String TAG = "BaseHeaderAdapter";
    protected Activity mActivity;
    protected List<QQGameMsgInfo> mMsgInfoList;
    protected final List<IHeaderView> mHeaderRecords = new ArrayList();
    private final List<String> mArkAppNameList = new ArrayList();
    private List<Boolean> mArkInited = new ArrayList();

    public BaseHeaderAdapter(Activity activity) {
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View createEmptyView() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.f167988oe, (ViewGroup) null, false);
        ((ImageView) inflate.findViewById(R.id.bwj)).setImageDrawable(URLDrawable.getDrawable(MiniGamePublicAccountConst.EMPTY_MSG));
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<QQGameMsgInfo> list = this.mMsgInfoList;
        return Math.min(list == null ? 0 : list.size(), this.mHeaderRecords.size());
    }

    public IHeaderView getHeaderView(int i3) {
        if (i3 < this.mHeaderRecords.size()) {
            return this.mHeaderRecords.get(i3);
        }
        return null;
    }

    public void initArk(int i3) {
        if (i3 >= this.mMsgInfoList.size() || i3 < 0 || i3 >= this.mArkInited.size() || i3 >= this.mHeaderRecords.size() || this.mArkInited.get(i3).booleanValue()) {
            return;
        }
        QQGameMsgInfo qQGameMsgInfo = this.mMsgInfoList.get(i3);
        IHeaderView iHeaderView = this.mHeaderRecords.get(i3);
        if (qQGameMsgInfo == null) {
            qQGameMsgInfo = new QQGameMsgInfo();
        }
        if (iHeaderView != null) {
            iHeaderView.init(qQGameMsgInfo, this.mActivity, i3, "");
        }
        this.mArkInited.set(i3, Boolean.TRUE);
    }

    public void onDestroy() {
        for (int i3 = 0; i3 < this.mHeaderRecords.size(); i3++) {
            try {
                if (this.mHeaderRecords.get(i3) instanceof GameArkView) {
                    ((GameArkView) this.mHeaderRecords.get(i3)).destory();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "header destroy i=" + i3);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "header destroy error=" + th5.toString());
            }
        }
        this.mHeaderRecords.clear();
        Iterator<String> it = this.mArkAppNameList.iterator();
        while (it.hasNext()) {
            ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).removeNotify(it.next());
        }
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(new String[0]);
    }

    public void onDestroyView() {
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).unRegistVolumnReceiver(this.mArkAppNameList);
    }

    public void setData(List<QQGameMsgInfo> list) {
        this.mMsgInfoList = list;
        this.mArkInited = new ArrayList(Collections.nCopies(list.size(), Boolean.FALSE));
        for (QQGameMsgInfo qQGameMsgInfo : list) {
            IHeaderView createHeader = createHeader(qQGameMsgInfo, this.mActivity);
            if (createHeader != null) {
                this.mHeaderRecords.add(createHeader);
                if (!TextUtils.isEmpty(qQGameMsgInfo.arkAppName)) {
                    ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addNotify(qQGameMsgInfo.arkAppName);
                    this.mArkAppNameList.add(qQGameMsgInfo.arkAppName);
                }
            }
        }
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).registVolumnReceiver(this.mArkAppNameList);
        notifyDataSetChanged();
    }

    private static IHeaderView createHeader(QQGameMsgInfo qQGameMsgInfo, Activity activity) {
        if (activity == null || activity.isFinishing()) {
            QLog.d(TAG, 4, "createHeader fail activity is null");
            return null;
        }
        if (qQGameMsgInfo != null) {
            try {
                if (qQGameMsgInfo.msgType == 1) {
                    return new GameArkView(activity, null);
                }
            } catch (Throwable th5) {
                QLog.d(TAG, 4, "decode header(web) faile:" + th5.getMessage());
            }
        }
        return null;
    }

    public void onPause() {
        IHeaderView headerView = getHeaderView(0);
        if (headerView != null) {
            headerView.onPause();
        }
    }

    public void onResume() {
        IHeaderView headerView = getHeaderView(0);
        if (headerView != null) {
            headerView.onResume();
        }
    }
}
