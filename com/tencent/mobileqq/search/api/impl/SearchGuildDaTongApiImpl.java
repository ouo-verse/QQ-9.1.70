package com.tencent.mobileqq.search.api.impl;

import android.view.View;
import com.tencent.mobileqq.search.api.ISearchGuildDaTongApi;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import lo2.m;
import lo2.t;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchGuildDaTongApiImpl implements ISearchGuildDaTongApi {
    public static final String CHILD_DOC_TYPE = "search_single_doc_type";
    public static final String GUILD_CHANNEL_ID = "sgrp_channel_id";
    public static final String GUILD_CHANNEL_SCORE = "sgrp_channel_code";
    public static final String GUILD_SEARCH_ITEM_CERTIFICATION = "sgrp_certification_show_tag";
    public static final String GUILD_SEARCH_ITEM_CONTENT = "sgrp_content_show_tag";
    public static final String GUILD_SEARCH_ITEM_FRIEND_NUM = "sgrp_friend_show_tag";
    public static final String GUILD_SEARCH_ITEM_IS_EXACT = "search_is_channel_exact";
    public static final String GUILD_SEARCH_ITEM_RECALL_NAME = "sgrp_recall_name";
    public static final String GUILD_SEARCH_ITEM_RECALL_QUALITY_SCORE = "sgrp_quality_score";
    public static final String GUILD_SEARCH_ITEM_RECALL_QUERY = "sgrp_query";
    public static final String GUILD_SEARCH_ITEM_RECALL_RELEVANCE_SCORE = "sgrp_relevance_score";
    public static final String GUILD_SEARCH_ITEM_RECALL_SCORE = "sgrp_score";
    public static final String GUILD_SEARCH_ITEM_RECALL_TRACE_ID = "sgrp_trace_id";
    public static final String GUILD_SEARCH_ITEM_STATE = "sgrp_avatar_show_tag";
    public static final String GUILD_SEARCH_RESULT_JOIN_STATE = "sgrp_join_state";
    public static final String GUILD_SEARCH_RES_COUNT = "sgrp_search_res_count";
    public static final String GUILD_SEARCH_TITLE_RECALL_QUERY = "sgrp_query_source";
    private static final String TAG = "SearchGuildDaTongApiImpl";

    private void reportExtraGuildSearchItem(View view, m mVar, int i3) {
        if (!(mVar instanceof t)) {
            return;
        }
        ho2.d X = ((t) mVar).X();
        VideoReport.setElementParam(view, "sgrp_channel_id", X.f405460f);
        VideoReport.setElementParam(view, GUILD_CHANNEL_SCORE, X.f405469o);
        VideoReport.setElementParam(view, GUILD_SEARCH_RES_COUNT, Integer.valueOf(X.f405470p));
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_STATE, X.f405464j.b());
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_CERTIFICATION, X.f405465k.a());
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_CONTENT, X.f405468n);
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_FRIEND_NUM, Integer.valueOf(X.f405462h));
        reportQueryReCallInfo(view, X);
    }

    private void reportQueryReCallInfo(View view, ho2.d dVar) {
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_RECALL_QUERY, dVar.f405471q.f405473a);
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_RECALL_NAME, dVar.f405471q.f405474b);
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_RECALL_RELEVANCE_SCORE, dVar.f405471q.f405475c);
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_RECALL_QUALITY_SCORE, dVar.f405471q.f405476d);
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_RECALL_SCORE, dVar.f405471q.f405477e);
        VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_RECALL_TRACE_ID, dVar.f405471q.f405478f);
    }

    private void reportTabSearchItem(View view, m mVar) {
        if (!(mVar instanceof t)) {
            return;
        }
        t tVar = (t) mVar;
        if (tVar.Y()) {
            ho2.d X = tVar.X();
            ai.m(view);
            VideoReport.setElementParam(view, "sgrp_channel_id", X.f405469o);
            VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_IS_EXACT, Integer.valueOf(X.f405472r));
            if (X.f405455a == 1) {
                VideoReport.setElementParam(view, GUILD_SEARCH_RESULT_JOIN_STATE, 1);
            } else {
                VideoReport.setElementParam(view, GUILD_SEARCH_RESULT_JOIN_STATE, 2);
            }
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchGuildDaTongApi
    public void reportDaTongForGuildItem(View view, v vVar, int i3) {
        if (view != null && (vVar instanceof m)) {
            m mVar = (m) vVar;
            am.r(view, String.valueOf(mVar.getTitle()), x.e(vVar), mVar.z(), i3, vVar.e(), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
            reportExtraGuildSearchItem(view, mVar, i3);
            reportTabSearchItem(view, mVar);
            return;
        }
        QLog.e(TAG, 1, "reportDaTongForGuildItem error, position " + i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchGuildDaTongApi
    public void reportGuildSearchTitle(View view, Object obj) {
        if (obj instanceof m) {
            reportGuildSearchTitle(view, (m) obj);
        }
    }

    private void reportGuildSearchTitle(View view, m mVar) {
        if (mVar instanceof t) {
            ho2.d X = ((t) mVar).X();
            VideoReport.setElementParam(view, GUILD_SEARCH_ITEM_RECALL_TRACE_ID, X.f405471q.f405478f);
            VideoReport.setElementParam(view, GUILD_SEARCH_TITLE_RECALL_QUERY, X.f405471q.f405473a);
            VideoReport.setElementParam(view, CHILD_DOC_TYPE, "17");
        }
    }
}
