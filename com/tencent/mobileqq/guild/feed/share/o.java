package com.tencent.mobileqq.guild.feed.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    protected c f223406a;

    /* renamed from: b, reason: collision with root package name */
    private final ShareActionSheet f223407b;

    /* renamed from: c, reason: collision with root package name */
    private final List<ShareActionSheetBuilder.ActionSheetItem> f223408c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    protected final List<ShareActionSheetBuilder.ActionSheetItem> f223409d = new ArrayList();

    public o(Context context, c cVar) {
        this.f223406a = cVar;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        this.f223407b = create;
        if (this.f223406a.f().getType() == 1) {
            create.setActionSheetTitle("");
        } else {
            create.setActionSheetTitle(context.getString(R.string.hja));
        }
        c();
        e();
        d();
    }

    private void c() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27).putExtra("guild_share_label", true).putExtras(bundle);
        this.f223407b.setIntentForStartForwardRecentActivity(intent);
        c cVar = this.f223406a;
        if (cVar != null && cVar.f() != null) {
            this.f223407b.setRowVisibility(0, 0, 0);
        }
    }

    private void e() {
        c cVar = this.f223406a;
        if (cVar != null && cVar.f() != null) {
            if (this.f223406a.f().getType() == 1) {
                QLog.e("GuildFeedPicViewerShareSheetBuilder", 1, "initSecondRow  video not share");
                return;
            }
            Iterator it = Arrays.asList(2, 171).iterator();
            while (it.hasNext()) {
                this.f223408c.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer) it.next()).intValue()));
            }
        }
    }

    public void a(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        this.f223409d.add(actionSheetItem);
    }

    public ShareActionSheet b() {
        this.f223407b.setActionSheetItems(this.f223408c, this.f223409d);
        return this.f223407b;
    }

    protected void d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(39);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f223409d.add(ShareActionSheetBuilder.ActionSheetItem.build(((Integer) it.next()).intValue()));
        }
    }

    public void f() {
        this.f223407b.updateUI();
    }
}
