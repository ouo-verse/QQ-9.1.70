package com.tencent.biz.qqcircle.manager;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f91573a;

    static {
        ArrayList arrayList = new ArrayList();
        f91573a = arrayList;
        arrayList.add("qfs_feed_comment_show");
        arrayList.add("qfs_feed_push_show");
        arrayList.add("qfs_search_entrance_show");
        arrayList.add("qfs_publish_entrance_show");
        arrayList.add("qfs_barrage_entrance_show");
        arrayList.add("qfs_fullscreen_entrance_show");
        arrayList.add("qfs_live_entrance_show");
        arrayList.add("qqcircle_hotcomment_user_switch_show");
        arrayList.add("qfs_community_entrance_show");
        arrayList.add("qfs_private_message_entrance_show");
        arrayList.add("qfs_give_gifts_entrance_show");
        arrayList.add("qfs_personal_entrance_show");
        arrayList.add("qfs_enable_push_rocket");
        arrayList.add("qqcircle_key_qfs_show_avatar_decorate");
        arrayList.add("qqcircle_verified_switch");
        arrayList.add("qqcircle_enable_personal_collect_box");
        arrayList.add("qqcircle_visitor_effort_frequency");
    }

    public static boolean a(String str) {
        if (f91573a.contains(str) && ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return false;
        }
        return true;
    }
}
