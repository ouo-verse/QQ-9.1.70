package com.tencent.mobileqq.guild.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private final ShareActionSheet f235151a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Integer> f235152b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Integer> f235153c;

    /* renamed from: d, reason: collision with root package name */
    private final Bundle f235154d;

    /* renamed from: e, reason: collision with root package name */
    private final q f235155e;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class a implements ShareActionSheetV2.l {

        /* renamed from: a, reason: collision with root package name */
        private final GuildSharePageSource f235156a;

        /* renamed from: b, reason: collision with root package name */
        private final String f235157b;

        /* renamed from: c, reason: collision with root package name */
        private final String f235158c;

        public a(GuildSharePageSource guildSharePageSource, String str, String str2) {
            this.f235156a = guildSharePageSource;
            this.f235157b = str;
            this.f235158c = str2;
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.l
        public void b(ActionSheet actionSheet) {
            x.this.f235155e.c(actionSheet, this.f235156a, this.f235157b, this.f235158c, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class b implements ShareActionSheetV2.m {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2.m
        public void a(View view, ImageView imageView, TextView textView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
            x.this.f235155e.a(view, imageView, textView, actionSheetItem);
        }
    }

    public x(Context context) {
        this(context, GuildSharePageSource.UNKNOWN, null, null);
    }

    private static List<ShareActionSheetBuilder.ActionSheetItem> c(List<Integer> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(it.next().intValue()));
        }
        return arrayList;
    }

    private void d() {
        this.f235154d.putString("appName", "com.tencent.qun.pro");
        this.f235154d.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, "1.0.0.0");
        this.f235154d.putString(QQCustomArkDialogUtil.APP_VIEW, "contact");
        this.f235154d.putString(QQCustomArkDialogUtil.META_DATA, "{}");
        this.f235154d.putFloat("scale", ViewUtils.getDensity());
    }

    private void e() {
        this.f235152b.add(2);
        this.f235152b.add(171);
        this.f235152b.add(9);
        this.f235152b.add(10);
        this.f235152b.add(3);
    }

    private void f() {
        this.f235153c.add(1);
    }

    private void j() {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1003).putExtra("is_ark_display_share", true).putExtra("forward_ark_app_name", "com.tencent.qun.pro").putExtra("forward_ark_app_view", "contact").putExtra("forward_ark_app_ver", "1.0.0.0").putExtra("forward_ark_app_prompt", "QQ\u5c0f\u7ad9").putExtra(ForwardRecentActivity.SELECTION_MODE, 2).putExtra("guild_share_label", true).putExtra("forward_ark_app_meta", "{}").putExtras(this.f235154d);
        this.f235151a.setIntentForStartForwardRecentActivity(intent);
    }

    public ShareActionSheet b() {
        j();
        List<ShareActionSheetBuilder.ActionSheetItem> c16 = c(this.f235152b);
        List<ShareActionSheetBuilder.ActionSheetItem> c17 = c(this.f235153c);
        this.f235151a.setActionSheetItems(c16, c17);
        this.f235155e.e(c17);
        return this.f235151a;
    }

    public x g(Collection<Integer> collection) {
        if (collection.isEmpty()) {
            return this;
        }
        this.f235153c.clear();
        this.f235153c.addAll(collection);
        return this;
    }

    public x h(List<Integer> list) {
        if (list.isEmpty()) {
            return this;
        }
        this.f235152b.clear();
        this.f235152b.addAll(list);
        return this;
    }

    public x i(Bundle bundle) {
        this.f235154d.putAll(bundle);
        return this;
    }

    public x(Context context, GuildSharePageSource guildSharePageSource, String str, String str2) {
        this.f235152b = new ArrayList();
        this.f235153c = new ArrayList();
        this.f235154d = new Bundle();
        this.f235155e = new q();
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        if (guildSharePageSource != GuildSharePageSource.UNKNOWN) {
            param.itemRender = new b();
            param.actionSheetRender = new a(guildSharePageSource, str, str2);
        }
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.f235151a = create;
        create.setRowVisibility(0, 0, 0);
        create.setActionSheetTitle(context.getString(R.string.f156741l1));
        d();
        e();
        f();
    }
}
