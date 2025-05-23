package com.tencent.biz.qqcircle.immersive.search.prompt;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import circlesearch.CircleSearchExhibition$StPromptResp;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.search.QFSSearchBaseFragment;
import com.tencent.biz.qqcircle.immersive.search.prompt.QFSSearchPromptFragment;
import com.tencent.biz.qqcircle.immersive.search.prompt.event.QFSSearchPromptSetTopEvent;
import com.tencent.biz.qqcircle.immersive.search.prompt.guessword.QFSSearchPromptGuessWordPart;
import com.tencent.biz.qqcircle.immersive.search.prompt.history.QFSSearchPromptHistoryListPart;
import com.tencent.biz.qqcircle.immersive.search.prompt.history.QFSSearchPromptHistoryPart;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankPart;
import com.tencent.biz.qqcircle.immersive.search.prompt.tag.QFSSearchPromptTagPart;
import com.tencent.biz.qqcircle.utils.k;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p70.e;
import u60.a;

/* loaded from: classes4.dex */
public class QFSSearchPromptFragment extends QFSSearchBaseFragment {
    private AppBarLayout E;
    private e F;

    private String sh() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (!(qCircleInitBean instanceof QFSSearchBean)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return "";
            }
            return "";
        }
        return String.valueOf(((QFSSearchBean) qCircleInitBean).getUserSource());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(UIStateData uIStateData) {
        CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp;
        PartManager partManager;
        if ((uIStateData.getState() == 2 || uIStateData.getState() == 3) && (circleSearchExhibition$StPromptResp = (CircleSearchExhibition$StPromptResp) uIStateData.getData()) != null && (partManager = this.mPartManager) != null) {
            partManager.broadcastMessage("qfs_search_hint_words_changed", new a(circleSearchExhibition$StPromptResp.shading_prompt, true));
            this.mPartManager.broadcastMessage("qfs_search_hot_rank_data", circleSearchExhibition$StPromptResp.ranking.get());
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (r60.a.f430818a.g()) {
            arrayList.add(new QFSSearchPromptHistoryPart());
        } else {
            arrayList.add(new QFSSearchPromptHistoryListPart());
        }
        arrayList.add(new QFSSearchPromptGuessWordPart());
        arrayList.add(new QFSSearchPromptTagPart());
        arrayList.add(new QFSSearchPromptRankPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        String sh5 = sh();
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_SOURCE, sh5);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.grk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSSearchPromptSetTopEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchPromptFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        AppBarLayout appBarLayout;
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QFSSearchPromptSetTopEvent) && (appBarLayout = this.E) != null) {
            appBarLayout.setExpanded(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.E = (AppBarLayout) view.findViewById(R.id.f53822dj);
        e eVar = (e) getViewModel(e.class);
        this.F = eVar;
        eVar.M1().observe(this, new Observer() { // from class: r60.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchPromptFragment.this.th((UIStateData) obj);
            }
        });
        ((e) getViewModel(e.class)).O1(false, null);
        k.j("exp_guess_search_feed_item_optimize");
    }
}
