package com.tencent.mobileqq.guild.feed.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedHeadBindParams;
import com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCustomManageTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class e extends GuildBaseFeedChildPresenter<ij1.g> implements View.OnClickListener {
    private View F;
    GuildFeedSingleHeadComponents G;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements GuildFeedSingleHeadComponents.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void a(@NonNull View view) {
            e.this.onClick(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.topic.adapter.section.GuildFeedSingleHeadComponents.b
        public void b() {
            e eVar = e.this;
            eVar.i(((ij1.g) eVar.f222800d).b(), 0, 1);
            e.this.p(new com.tencent.mobileqq.guild.feed.event.a(1));
        }
    }

    public e(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(View view) {
        T t16;
        if (view != null && (t16 = this.f222800d) != 0 && ((ij1.g) t16).b() != null) {
            GuildFeedBaseInitBean q16 = ax.q(this.F.getContext());
            if (q16 != null) {
                com.tencent.mobileqq.guild.feed.report.e.c(((ij1.g) this.f222800d).b(), "avatar_click", q16.getPageId(), q16.getPageForumType(q16.getPageId()), q16.getPrePageId(), q16.getPrePageForumType(q16.getPrePageId()));
            }
            com.tencent.mobileqq.guild.feed.report.d.a("clck", view, "em_sgrp_forum_avatar", e());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        this.F = view;
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.wak), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() != R.id.wac && view.getId() != R.id.wah) {
                i(((ij1.g) this.f222800d).b(), 0, 1);
                p(new com.tencent.mobileqq.guild.feed.event.a(1));
            } else {
                if (this.D.getBusinessType() == 7) {
                    GProStUser gProStUser = ((ij1.g) this.f222800d).b().poster;
                    if (gProStUser != null) {
                        long j3 = ((ij1.g) this.f222800d).b().groupCode;
                        long j16 = gProStUser.uin;
                        QLog.d("GuildFeedChildHeaderPresenter", 1, "\u8c03\u8d77\u7fa4\u5e16\u5b50\u6210\u5458\u8d44\u6599\u5361 groupId = " + j3 + ", uin = " + j16);
                        ax.M(String.valueOf(j3), String.valueOf(j16));
                    }
                } else {
                    String valueOf = String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.guildId);
                    String valueOf2 = String.valueOf(((ij1.g) this.f222800d).b().idd);
                    QLog.d("GuildFeedChildHeaderPresenter", 1, "\u8c03\u8d77\u9891\u9053\u5e16\u5b50\u8d44\u6599\u5361 guildId:" + valueOf + ", feedId:" + valueOf2 + ", tinyId:" + String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.channelId) + ", getChannelId: " + this.D.getChannelId());
                    ax.I((Activity) view.getContext(), valueOf, this.D.getChannelId(), ((ij1.g) this.f222800d).b().poster.idd, valueOf2, this.D.getBusinessType(), this.D.getJoinInfoParam());
                }
                t(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
        super.onPreloadResult(view);
        GuildFeedSingleHeadComponents guildFeedSingleHeadComponents = new GuildFeedSingleHeadComponents(new a());
        this.G = guildFeedSingleHeadComponents;
        guildFeedSingleHeadComponents.g(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    @SuppressLint({"ResourceAsColor"})
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void k(ij1.g gVar, int i3) {
        int i16;
        String str;
        super.k(gVar, i3);
        if (gVar != null && gVar.b() != null && gVar.b().poster != null) {
            GProStUser gProStUser = gVar.b().poster;
            View view = this.F;
            if (view != null && view.getContext() != null) {
                GuildFeedBaseInitBean q16 = ax.q(this.F.getContext());
                if (q16 != null) {
                    i16 = q16.getBusinessType();
                } else {
                    i16 = 6;
                }
                if (i16 == 7) {
                    int i17 = gProStUser.nickFlag;
                    str = gProStUser.nick;
                    if (i17 != 1) {
                        if (i17 == 2 && ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(gProStUser.uin)), "GuildFeedChildHeaderPresenter");
                            if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B() && !TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
                                str = friendsSimpleInfoWithUid.r();
                            }
                        } else {
                            str = "";
                        }
                    }
                } else {
                    str = gProStUser.nick;
                }
                GProCustomManageTag gProCustomManageTag = gProStUser.manageTag;
                String str2 = gProCustomManageTag.tagName;
                int i18 = gProCustomManageTag.color;
                if (str != null) {
                    this.G.f(GuildFeedHeadBindParams.c(str, str2, i18), i3, null);
                }
            }
        }
    }
}
