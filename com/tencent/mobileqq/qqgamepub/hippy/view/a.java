package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountConst;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.mobileqq.qqgamepub.view.a> f264560d;

    /* renamed from: e, reason: collision with root package name */
    private List<QQGameMsgInfo> f264561e;

    /* renamed from: f, reason: collision with root package name */
    private Context f264562f;

    /* renamed from: h, reason: collision with root package name */
    private GamePAHippyFragment f264563h;

    public a(List<com.tencent.mobileqq.qqgamepub.view.a> list, List<QQGameMsgInfo> list2, Context context, GamePAHippyFragment gamePAHippyFragment) {
        this.f264562f = context;
        this.f264563h = gamePAHippyFragment;
        ArrayList arrayList = new ArrayList();
        this.f264560d = arrayList;
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList();
        this.f264561e = arrayList2;
        arrayList2.addAll(list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RelativeLayout d(ViewGroup viewGroup, int i3, com.tencent.mobileqq.qqgamepub.view.a aVar, QQGameMsgInfo qQGameMsgInfo) {
        TextView textView;
        RelativeLayout.LayoutParams layoutParams;
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GamePubAccountHeadAdapt", 2, "headerView = " + aVar.getClass().getSimpleName());
        }
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        View view = (View) aVar;
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(13, view.getId());
        if (qQGameMsgInfo != null) {
            Pair<TextView, RelativeLayout.LayoutParams> f16 = QQGameUIHelper.f(qQGameMsgInfo, this.f264562f);
            textView = (TextView) f16.first;
            layoutParams = (RelativeLayout.LayoutParams) f16.second;
        } else {
            textView = null;
            layoutParams = null;
        }
        relativeLayout.addView(view, layoutParams2);
        if (textView != null && layoutParams != null) {
            relativeLayout.addView(textView, layoutParams);
        }
        viewGroup.addView(relativeLayout, layoutParams2);
        if (qQGameMsgInfo != null) {
            aVar.b(qQGameMsgInfo, (Activity) this.f264562f, i3, GamePubAccountHelper.s());
            this.f264563h.Oh(i3, aVar);
        } else {
            aVar.b(new QQGameMsgInfo(), (Activity) this.f264562f, i3, GamePubAccountHelper.s());
        }
        return relativeLayout;
    }

    public View createEmptyView() {
        View inflate = LayoutInflater.from(this.f264562f).inflate(R.layout.f167988oe, (ViewGroup) null, false);
        ((ImageView) inflate.findViewById(R.id.bwj)).setImageDrawable(URLDrawable.getDrawable(MiniGamePublicAccountConst.EMPTY_MSG));
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void e(List<com.tencent.mobileqq.qqgamepub.view.a> list, List<QQGameMsgInfo> list2) {
        this.f264560d.clear();
        this.f264560d.addAll(list);
        this.f264561e.clear();
        this.f264561e.addAll(list2);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        List<com.tencent.mobileqq.qqgamepub.view.a> list = this.f264560d;
        if (list == null || list.size() <= 1) {
            return 1;
        }
        return this.f264560d.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        QQGameMsgInfo qQGameMsgInfo;
        com.tencent.mobileqq.qqgamepub.view.a aVar;
        List<QQGameMsgInfo> list = this.f264561e;
        if (list != null && list.size() != 0) {
            if (i3 < this.f264561e.size()) {
                qQGameMsgInfo = this.f264561e.get(i3);
            } else {
                qQGameMsgInfo = null;
            }
            if (i3 < this.f264560d.size()) {
                aVar = this.f264560d.get(i3);
            } else {
                aVar = null;
            }
            if (aVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGamePub_GamePubAccountHeadAdapt", 2, "headerView = null");
                }
                return null;
            }
            if ((aVar instanceof MoreMsgHeaderView) && i3 != this.f264561e.size()) {
                return null;
            }
            return d(viewGroup, i3, aVar, qQGameMsgInfo);
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
}
