package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedTopDataEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedTopView extends GuildBaseWidgetView {

    /* renamed from: d, reason: collision with root package name */
    private List<ij1.h> f224234d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f224235e;

    /* renamed from: f, reason: collision with root package name */
    private a f224236f;

    /* renamed from: h, reason: collision with root package name */
    private View.OnClickListener f224237h;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface a {
        void b0(ij1.h hVar);
    }

    public GuildFeedTopView(@NonNull Context context) {
        this(context, null);
    }

    private void initView() {
        this.f224235e = (LinearLayout) findViewById(R.id.f165193v42);
        this.f224237h = new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.widget.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFeedTopView.this.m0(view);
            }
        };
    }

    private boolean l0(@NonNull List<ij1.h> list) {
        boolean z16;
        boolean z17;
        if (this.f224234d.isEmpty() && list.isEmpty()) {
            return false;
        }
        if (this.f224234d.size() != list.size()) {
            return true;
        }
        try {
            Iterator it = new CopyOnWriteArrayList(list).iterator();
            boolean z18 = false;
            while (it.hasNext()) {
                ij1.h hVar = (ij1.h) it.next();
                Iterator<ij1.h> it5 = this.f224234d.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        ij1.h next = it5.next();
                        if (TextUtils.equals(next.f407814h, hVar.f407814h)) {
                            if (!TextUtils.equals(next.C, hVar.C) || ((TextUtils.isEmpty(next.D) && !TextUtils.isEmpty(hVar.D)) || (!TextUtils.isEmpty(next.D) && TextUtils.isEmpty(hVar.D)))) {
                                z16 = true;
                            } else {
                                z17 = false;
                                z16 = true;
                            }
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                z17 = z16;
                if (z16 && !z17) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (z18) {
                    break;
                }
            }
            return z18;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("GuildFeedTopView", 2, "checkTopListDataModified : ", th5);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.f224236f;
        if (aVar != null) {
            aVar.b0(((GuildFeedTopItemView) view).b());
        } else {
            QLog.e("GuildFeedTopView", 1, "feedItemClickListener, itemClickListener is null!");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void n0(@NonNull List<ij1.h> list) {
        int i3;
        QLog.d("GuildFeedTopView", 1, "updateFeedTopListView: size[" + list.size() + "]");
        this.f224235e.removeAllViews();
        for (ij1.h hVar : list) {
            GuildFeedTopItemView guildFeedTopItemView = new GuildFeedTopItemView(getContext());
            guildFeedTopItemView.a(hVar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.tencent.mobileqq.guild.feed.util.e.a(getContext(), 40.0f));
            guildFeedTopItemView.setOnClickListener(this.f224237h);
            this.f224235e.addView(guildFeedTopItemView, layoutParams);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_forum_toppost_num", Integer.valueOf(list.size()));
            hashMap.put("sgrp_rank", Integer.valueOf(list.indexOf(hVar) + 1));
            hashMap.put("sgrp_content_id", hVar.f407814h);
            hashMap.put("sgrp_feed_id", hVar.f407814h);
            hashMap.put("sgrp_top_type", Integer.valueOf(hVar.M));
            if (hVar.L) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_remind_type", Integer.valueOf(i3));
            com.tencent.mobileqq.guild.feed.report.d.d(guildFeedTopItemView, "em_sgrp_forum_toppost", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f_3;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        setParentView(null);
        this.f224236f = null;
    }

    public void setFeedTopListData(@NonNull List<ij1.h> list) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedTopDataEvent(list));
        if (l0(list)) {
            QLog.d("GuildFeedTopView", 1, "setFeedTopListData: size[" + list.size() + "]");
            this.f224234d.clear();
            this.f224234d.addAll(list);
            n0(this.f224234d);
            return;
        }
        QLog.e("GuildFeedTopView", 1, "no need to updateFeedTopListView!");
    }

    public void setOnFeedTopItemClickListener(a aVar) {
        this.f224236f = aVar;
    }

    public GuildFeedTopView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedTopView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f224234d = new ArrayList();
        initView();
    }
}
