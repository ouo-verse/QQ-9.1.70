package com.tencent.biz.pubaccount.weishi.comment;

import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import com.tencent.biz.pubaccount.weishi.event.WSActivityResultEvent;
import com.tencent.biz.pubaccount.weishi.event.WSCommentSuccessEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes32.dex */
public class WSCommentInputPresenter {

    /* renamed from: e, reason: collision with root package name */
    private static final int f80487e = Color.parseColor("#fe9526");

    /* renamed from: a, reason: collision with root package name */
    private final e f80488a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<WSCommentFriendBaseInfo> f80489b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f80490c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private int f80491d;

    public WSCommentInputPresenter(e eVar) {
        this.f80488a = eVar;
    }

    private String b(WSCommentFriendBaseInfo wSCommentFriendBaseInfo) {
        return "@{uid:" + wSCommentFriendBaseInfo.getUin() + ",uidtype:2,nick:" + URLEncoder.encode(wSCommentFriendBaseInfo.getName()) + "}";
    }

    private String c(String str) {
        return "@" + str + " ";
    }

    private StyleSpan g() {
        return new StyleSpan(0) { // from class: com.tencent.biz.pubaccount.weishi.comment.WSCommentInputPresenter.1
            @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(WSCommentInputPresenter.f80487e);
            }
        };
    }

    private void i(ArrayList<ResultRecord> arrayList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<ResultRecord> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ResultRecord next = it.next();
            if (!this.f80490c.contains(next.uin)) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(next.uin), "WSCommentInputPresenter");
                if (friendsSimpleInfoWithUid != null) {
                    this.f80490c.add(next.uin);
                    this.f80489b.add(new WSCommentFriendBaseInfo(next.uin, friendsSimpleInfoWithUid.p()));
                    String c16 = c(friendsSimpleInfoWithUid.p());
                    int length = c16.length();
                    spannableStringBuilder.append((CharSequence) c16);
                    int i16 = length + i3;
                    spannableStringBuilder.setSpan(g(), i3, i16, 17);
                    this.f80491d = Math.max(this.f80491d, c16.length());
                    i3 = i16;
                }
            }
        }
        this.f80488a.y(spannableStringBuilder);
    }

    public int d() {
        return this.f80491d;
    }

    public ArrayList<String> e() {
        this.f80490c.clear();
        Iterator<WSCommentFriendBaseInfo> it = this.f80489b.iterator();
        while (it.hasNext()) {
            this.f80490c.add(it.next().getUin());
        }
        return this.f80490c;
    }

    public ArrayList<WSCommentFriendBaseInfo> f() {
        return this.f80489b;
    }

    public void j(BaseFragment baseFragment, int i3, String str) {
        this.f80490c.clear();
        Iterator<WSCommentFriendBaseInfo> it = this.f80489b.iterator();
        while (it.hasNext()) {
            WSCommentFriendBaseInfo next = it.next();
            if (!str.contains(c(next.getName()))) {
                it.remove();
            } else {
                this.f80490c.add(next.getUin());
            }
        }
        int size = this.f80490c.size();
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 5 - size);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, this.f80490c);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(baseFragment, intent, i3);
    }

    public void k(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof WSActivityResultEvent) {
            h(wSSimpleBaseEvent);
        } else if (wSSimpleBaseEvent instanceof WSCommentSuccessEvent) {
            this.f80489b.clear();
            this.f80490c.clear();
        }
    }

    public String l(String str) {
        Iterator<WSCommentFriendBaseInfo> it = this.f80489b.iterator();
        while (it.hasNext()) {
            WSCommentFriendBaseInfo next = it.next();
            String c16 = c(next.getName());
            if (str.contains(c16)) {
                str = str.replace(c16, b(next));
            } else {
                it.remove();
            }
        }
        return str;
    }

    private void h(WSSimpleBaseEvent wSSimpleBaseEvent) {
        ArrayList<ResultRecord> parcelableArrayListExtra;
        WSActivityResultEvent wSActivityResultEvent = (WSActivityResultEvent) wSSimpleBaseEvent;
        x.b("WSCommentInputPresenter", "[WSCommentInputPresenter.java][onReceiveEvent] event:" + wSSimpleBaseEvent);
        if (wSActivityResultEvent.getResultCode() != -1 || (parcelableArrayListExtra = wSActivityResultEvent.getData().getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET)) == null || parcelableArrayListExtra.size() == 0) {
            return;
        }
        i(parcelableArrayListExtra);
    }
}
