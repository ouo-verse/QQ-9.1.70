package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory;
import com.tencent.biz.pubaccount.weishi.verticalvideo.speed.SpeedSelectedView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes32.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f81725a = Boolean.FALSE;

    public static void A(final Context context, final j10.a aVar) {
        if (bb.E() || aVar == null) {
            return;
        }
        f81725a = Boolean.TRUE;
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        stSimpleMetaFeed stsimplemetafeed = aVar.f409063a;
        if (stsimplemetafeed != null && stsimplemetafeed.gdt_ad_type == 1 && stsimplemetafeed.gdt_ad_info != null) {
            w(create);
        } else {
            x(context, aVar, create);
        }
        create.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.biz.pubaccount.weishi.util.ap
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                az.s(context, aVar, actionSheetItem, shareActionSheet);
            }
        });
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
            create.setIntentForStartForwardRecentActivity(activity.getIntent());
        }
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.biz.pubaccount.weishi.util.aq
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                az.z(j10.a.this);
            }
        });
        create.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.biz.pubaccount.weishi.util.ar
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                az.y(j10.a.this);
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.pubaccount.weishi.util.as
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                az.y(j10.a.this);
            }
        });
        create.show();
    }

    public static void k(final Context context, final j10.a aVar) {
        if (bb.E()) {
            return;
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = context;
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        create.setActionSheetTitle("");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
        create.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.biz.pubaccount.weishi.util.au
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                az.m(context, aVar, actionSheetItem, shareActionSheet);
            }
        });
        create.setActionSheetItems(arrayList, arrayList2);
        create.setRowVisibility(8, 8, 0);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
            create.setIntentForStartForwardRecentActivity(activity.getIntent());
        }
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.biz.pubaccount.weishi.util.av
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                az.z(j10.a.this);
            }
        });
        create.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.biz.pubaccount.weishi.util.aw
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                az.y(j10.a.this);
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.pubaccount.weishi.util.ax
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                az.y(j10.a.this);
            }
        });
        create.show();
    }

    private static void l(Context context, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, j10.a aVar) {
        com.tencent.biz.pubaccount.weishi.share.action.a a16 = WSShareActionFactory.f81580a.a(actionSheetItem.action);
        if (a16 != null) {
            a16.a(context, actionSheetItem, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(Context context, j10.a aVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        l(context, actionSheetItem, aVar);
        shareActionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit q(ShareActionSheet shareActionSheet, j10.a aVar) {
        shareActionSheet.dismiss();
        y(aVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ View r(Context context, final j10.a aVar, final ShareActionSheet shareActionSheet) {
        return new SpeedSelectedView(context, aVar, new Function0() { // from class: com.tencent.biz.pubaccount.weishi.util.ay
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit q16;
                q16 = az.q(ShareActionSheet.this, aVar);
                return q16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(Context context, j10.a aVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        l(context, actionSheetItem, aVar);
        shareActionSheet.dismiss();
    }

    private static void w(ShareActionSheet shareActionSheet) {
        shareActionSheet.setActionSheetTitle("");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(90));
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(89));
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
        shareActionSheet.setRowVisibility(8, 8, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(j10.a aVar) {
        if (aVar == null || aVar.a() == null) {
            return;
        }
        aVar.a().H0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(j10.a aVar) {
        if (aVar == null || aVar.a() == null) {
            return;
        }
        aVar.a().K1(2);
    }

    private static void x(final Context context, final j10.a aVar, final ShareActionSheet shareActionSheet) {
        shareActionSheet.setActionSheetTitle(context.getString(R.string.bgc));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(26));
        }
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        if (aVar.f409072j) {
            if (aVar.f409073k) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(44));
            }
            arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
        }
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
        shareActionSheet.setRowVisibility(0, 0, 0);
        if (!u10.c.b() || TextUtils.isEmpty(aVar.f409068f)) {
            return;
        }
        shareActionSheet.setBottomBarInterface(new ShareActionSheet.b() { // from class: com.tencent.biz.pubaccount.weishi.util.at
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.b
            public final View a() {
                View r16;
                r16 = az.r(context, aVar, shareActionSheet);
                return r16;
            }
        });
    }
}
