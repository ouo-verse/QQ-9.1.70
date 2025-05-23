package com.tencent.mobileqq.widget.share;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.fe;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ShareActionSheetV2 implements ShareActionSheet {
    public static final n I0 = new n();
    private m B0;
    private ResultReceiver C;
    private DialogInterface.OnShowListener C0;
    private boolean D;
    private ActionSheet.WatchDismissActions D0;
    private DialogInterface.OnDismissListener E0;
    protected ActionSheet F;
    protected View G;
    private DialogInterface.OnCancelListener G0;
    protected ElasticHorScrView H;
    protected ElasticHorScrView I;
    protected ElasticHorScrView J;
    protected LinearLayout K;
    protected TextView L;
    protected LinearLayout M;
    protected LinearLayout N;
    protected ImageView P;
    protected int Q;
    protected int R;
    protected int S;
    protected Bundle T;
    private ShareActionSheet.b U;
    protected CharSequence V;
    protected List<ShareActionSheetBuilder.ActionSheetItem>[] W;

    /* renamed from: c0, reason: collision with root package name */
    protected int f317427c0;

    /* renamed from: d, reason: collision with root package name */
    protected final Param f317428d;

    /* renamed from: d0, reason: collision with root package name */
    protected int f317429d0;

    /* renamed from: e, reason: collision with root package name */
    protected WeakReference<Context> f317430e;

    /* renamed from: e0, reason: collision with root package name */
    protected int f317431e0;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.sharehelper.e f317432f;

    /* renamed from: f0, reason: collision with root package name */
    protected int f317433f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f317434g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f317435h;

    /* renamed from: h0, reason: collision with root package name */
    protected int f317436h0;

    /* renamed from: i0, reason: collision with root package name */
    protected k f317438i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f317439j0;

    /* renamed from: l0, reason: collision with root package name */
    protected GridView f317441l0;

    /* renamed from: m0, reason: collision with root package name */
    protected GridView f317443m0;

    /* renamed from: n0, reason: collision with root package name */
    protected GridView f317444n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f317445o0;

    /* renamed from: p0, reason: collision with root package name */
    private String f317446p0;

    /* renamed from: q0, reason: collision with root package name */
    private Intent f317447q0;

    /* renamed from: r0, reason: collision with root package name */
    private SparseArray<com.tencent.mobileqq.armap.f> f317448r0;

    /* renamed from: t0, reason: collision with root package name */
    private ShareActionSheet.OnItemClickListener f317450t0;

    /* renamed from: u0, reason: collision with root package name */
    private ShareActionSheet.c f317451u0;

    /* renamed from: v0, reason: collision with root package name */
    private ShareActionSheet.a f317452v0;

    /* renamed from: i, reason: collision with root package name */
    protected AdapterView.OnItemClickListener f317437i = new c();

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.armap.e f317442m = new d();
    private Application.ActivityLifecycleCallbacks E = new e();
    protected List<ShareActionSheetBuilder.ActionSheetItem> X = new ArrayList(0);
    protected List<ShareActionSheetBuilder.ActionSheetItem> Y = new ArrayList(0);
    protected List<ShareActionSheetBuilder.ActionSheetItem> Z = new ArrayList(0);

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f317425a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f317426b0 = true;

    /* renamed from: k0, reason: collision with root package name */
    protected boolean f317440k0 = true;

    /* renamed from: s0, reason: collision with root package name */
    private DialogInterface.OnDismissListener f317449s0 = new f();

    /* renamed from: w0, reason: collision with root package name */
    private int f317453w0 = 0;

    /* renamed from: x0, reason: collision with root package name */
    private int f317454x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    private int f317455y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    private DialogInterface.OnShowListener f317456z0 = new g();
    private final ActionSheet.g A0 = new h();
    private DialogInterface.OnCancelListener F0 = new i();
    private View.OnClickListener H0 = new b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ActionSheetItemAdapter extends BaseAdapter {
        private boolean C;

        /* renamed from: d, reason: collision with root package name */
        private ShareActionSheetV2 f317457d;

        /* renamed from: e, reason: collision with root package name */
        private List<ShareActionSheetBuilder.ActionSheetItem> f317458e;

        /* renamed from: f, reason: collision with root package name */
        private LayoutInflater f317459f;

        /* renamed from: h, reason: collision with root package name */
        private int f317460h = 0;

        /* renamed from: i, reason: collision with root package name */
        private a f317461i;

        /* renamed from: m, reason: collision with root package name */
        private Resources f317462m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.widget.share.ShareActionSheetV2$ActionSheetItemAdapter$2, reason: invalid class name */
        /* loaded from: classes20.dex */
        public class AnonymousClass2 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f317466d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ WeakReference f317467e;

            AnonymousClass2(String str, WeakReference weakReference) {
                this.f317466d = str;
                this.f317467e = weakReference;
            }

            @Override // java.lang.Runnable
            public void run() {
                String guildAvatarUrlIPC = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildAvatarUrlIPC(this.f317466d, 100);
                if (TextUtils.isEmpty(guildAvatarUrlIPC)) {
                    QLog.e("ShareActionSheetV2", 1, "getGuildAvatarUrl fail");
                } else {
                    QQPicLoader.f201806a.e(Option.obtain().setUrl(guildAvatarUrlIPC).setRequestWidth(ViewUtils.dpToPx(52.0f)).setRequestHeight(ViewUtils.dip2px(52.0f)), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter.2.1
                        @Override // com.tencent.libra.listener.IPicLoadStateListener
                        public void onStateChange(LoadState loadState, Option option) {
                            final Bitmap bitmap;
                            if (!loadState.isFinishSuccess()) {
                                QLog.e("ShareActionSheetV2", 4, "loadImage by libra fail");
                                return;
                            }
                            Bitmap resultBitMap = option.getResultBitMap();
                            if (resultBitMap != null) {
                                bitmap = BaseImageUtil.getCircleFaceBitmap(resultBitMap, 50, 50);
                            } else {
                                bitmap = null;
                            }
                            if (bitmap == null) {
                                QLog.e("ShareActionSheetV2", 1, "loadImage by libra fail, circle bitmap is null");
                            } else {
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ShareActionSheetBuilder.c cVar = (ShareActionSheetBuilder.c) AnonymousClass2.this.f317467e.get();
                                        if (cVar == null) {
                                            return;
                                        }
                                        BitmapDrawable bitmapDrawable = new BitmapDrawable(cVar.f307308b.getContext().getResources(), bitmap);
                                        cVar.f307311e.iconDrawable = bitmapDrawable;
                                        cVar.f307308b.setImageDrawable(bitmapDrawable);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes20.dex */
        private static class a {

            /* renamed from: a, reason: collision with root package name */
            private final Drawable f317471a;

            /* renamed from: b, reason: collision with root package name */
            private final Drawable f317472b;

            /* renamed from: c, reason: collision with root package name */
            private ActionSheetItemAdapter f317473c;

            a(Context context, ActionSheetItemAdapter actionSheetItemAdapter) {
                this.f317473c = actionSheetItemAdapter;
                this.f317471a = context.getResources().getDrawable(d());
                this.f317472b = e(context);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Drawable f(Drawable drawable) {
                Drawable mutate = drawable.getConstantState().newDrawable().mutate();
                mutate.setColorFilter(Integer.MAX_VALUE, PorterDuff.Mode.MULTIPLY);
                return mutate;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Drawable g(Drawable drawable) {
                return new LayerDrawable(new Drawable[]{drawable, this.f317472b});
            }

            Drawable c(Drawable drawable, int i3, int i16) {
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f317471a, drawable});
                layerDrawable.setLayerInset(1, i3, i16, i3, i16);
                return layerDrawable;
            }

            public int d() {
                return R.drawable.j2b;
            }

            public Drawable e(Context context) {
                return context.getResources().getDrawable(R.drawable.j2e);
            }

            StateListDrawable h(Drawable drawable, Drawable drawable2) {
                int[] iArr = {android.R.attr.state_pressed};
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(iArr, drawable2);
                stateListDrawable.addState(new int[0], drawable);
                return stateListDrawable;
            }
        }

        public ActionSheetItemAdapter(Context context, List<ShareActionSheetBuilder.ActionSheetItem> list, ShareActionSheetV2 shareActionSheetV2, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetV2", 2, "ActionSheetItemAdapter() called with: context = [" + context + "], objects = [" + list + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
            }
            this.f317458e = list;
            this.f317459f = LayoutInflater.from(context);
            this.f317457d = shareActionSheetV2;
            this.C = z16;
        }

        private static void a(ShareActionSheetBuilder.c cVar) {
            ShareActionSheetBuilder.ActionSheetItem actionSheetItem = cVar.f307311e;
            Drawable drawable = actionSheetItem.iconDrawable;
            if (drawable != null) {
                cVar.f307308b.setBackground(drawable);
            } else {
                cVar.f307308b.setBackgroundResource(actionSheetItem.icon);
            }
        }

        private void b(ShareActionSheetBuilder.c cVar) {
            ShareActionSheetBuilder.ActionSheetItem actionSheetItem = cVar.f307311e;
            int i3 = actionSheetItem.action;
            if (i3 == 72) {
                int i16 = actionSheetItem.uinType;
                if (i16 != 10014 && i16 != 10027) {
                    d(i16, actionSheetItem.uin, cVar.f307308b, cVar, this, this.f317457d);
                    return;
                } else {
                    f(actionSheetItem.guildId, cVar);
                    return;
                }
            }
            if (i3 == 198) {
                g(cVar);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static void d(int i3, String str, ImageView imageView, ShareActionSheetBuilder.c cVar, ActionSheetItemAdapter actionSheetItemAdapter, ShareActionSheetV2 shareActionSheetV2) {
            WeakReference<Context> weakReference;
            int i16;
            if (imageView != null && !TextUtils.isEmpty(str) && (weakReference = shareActionSheetV2.f317430e) != null && weakReference.get() != null) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 1000 && i3 != 1004 && i3 != 1006) {
                            if (i3 != 3000) {
                                if (i3 != 6000) {
                                    if (i3 != 10008 && i3 != 10010) {
                                        i16 = -1;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                i16 = 101;
                            }
                        }
                    } else if (!TextUtils.isEmpty(cVar.f307311e.argus) && cVar.f307311e.argus.contains("isNewTroop=1")) {
                        i16 = 113;
                    } else {
                        i16 = 4;
                    }
                    if (i16 != -1) {
                        return;
                    }
                    if (shareActionSheetV2.f317448r0 == null) {
                        shareActionSheetV2.f317448r0 = new SparseArray();
                    }
                    com.tencent.mobileqq.armap.f fVar = (com.tencent.mobileqq.armap.f) shareActionSheetV2.f317448r0.get(i16);
                    if (fVar == null) {
                        fVar = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(shareActionSheetV2.f317430e.get(), i16);
                        fVar.e((byte) 3);
                        fVar.init();
                        shareActionSheetV2.f317448r0.put(i16, fVar);
                    }
                    imageView.setTag(str);
                    fVar.a(shareActionSheetV2.f317442m);
                    Bitmap b16 = fVar.b(str, true);
                    if (b16 == null) {
                        return;
                    }
                    cVar.f307311e.iconDrawable = new BitmapDrawable(b16);
                    a(cVar);
                    return;
                }
                i16 = 1;
                if (i16 != -1) {
                }
            }
        }

        private static void e(String str, ShareActionSheetBuilder.c cVar) {
            ThreadManagerV2.excute(new AnonymousClass2(str, new WeakReference(cVar)), 128, null, true);
        }

        private static void f(final String str, final ShareActionSheetBuilder.c cVar) {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("share_action_sheet_image_load_libra_disable", false)) {
                e(str, cVar);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final String guildAvatarUrlIPC = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildAvatarUrlIPC(str, 100);
                        if (!TextUtils.isEmpty(guildAvatarUrlIPC)) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Drawable guildFaceIcon = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildFaceIcon(guildAvatarUrlIPC, 100, BaseImageUtil.getDefaultFaceDrawable(false), true);
                                    if (guildFaceIcon != null) {
                                        ShareActionSheetBuilder.c cVar2 = cVar;
                                        cVar2.f307311e.iconDrawable = guildFaceIcon;
                                        cVar2.f307308b.setImageDrawable(guildFaceIcon);
                                    }
                                }
                            });
                        }
                    }
                }, 16, null, true);
            }
        }

        private void g(ShareActionSheetBuilder.c cVar) {
            Drawable guildFaceIcon = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildFaceIcon(cVar.f307311e.matchFriendAvatarUrl, 100, null, true);
            if (guildFaceIcon != null) {
                cVar.f307311e.iconDrawable = guildFaceIcon;
                cVar.f307308b.setImageDrawable(guildFaceIcon);
            }
        }

        private void h(ShareActionSheetBuilder.c cVar) {
            cVar.f307310d.setRedDot();
            cVar.f307310d.setFixMinSize();
            cVar.f307310d.setVisibility(0);
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ShareActionSheetBuilder.ActionSheetItem getItem(int i3) {
            if (this.f317458e != null && i3 >= 0) {
                int i16 = -1;
                for (int i17 = 0; i17 < this.f317458e.size(); i17++) {
                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f317458e.get(i17);
                    if (actionSheetItem != null && actionSheetItem.visibility == 0) {
                        i16++;
                    }
                    if (i16 == i3) {
                        return actionSheetItem;
                    }
                }
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<ShareActionSheetBuilder.ActionSheetItem> list = this.f317458e;
            int i3 = 0;
            if (list == null) {
                return 0;
            }
            for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
                if (actionSheetItem != null && actionSheetItem.visibility == 0) {
                    i3++;
                }
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ShareActionSheetBuilder.c cVar;
            Param param;
            m mVar;
            int i16;
            if (this.f317462m == null) {
                this.f317462m = viewGroup.getContext().getResources();
            }
            if (this.f317460h == 0) {
                this.f317460h = (int) this.f317462m.getDimension(R.dimen.f158592jv);
            }
            if (this.f317461i == null) {
                this.f317461i = new a(viewGroup.getContext(), this);
            }
            int i17 = 0;
            if (view == null) {
                view = this.f317459f.inflate(R.layout.f167788hi, viewGroup, false);
                cVar = new ShareActionSheetBuilder.c();
                cVar.f307308b = (ImageView) view.findViewById(R.id.iqu);
                cVar.f307307a = (TextView) view.findViewById(R.id.iqv);
                cVar.f307310d = (QUIBadge) view.findViewById(R.id.f84194ll);
                cVar.f307309c = (ImageView) view.findViewById(R.id.f84184lk);
                view.setTag(cVar);
            } else {
                cVar = (ShareActionSheetBuilder.c) view.getTag();
            }
            ShareActionSheetBuilder.ActionSheetItem item = getItem(i3);
            cVar.f307311e = item;
            if (item == null) {
                QLog.e("ShareActionSheetV2", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + i3 + ") == null !!!");
            } else {
                view.setId(item.f307296id);
                float dimension = this.f317462m.getDimension(R.dimen.f158592jv);
                cVar.f307307a.getPaint().setTextSize(this.f317462m.getDimensionPixelSize(R.dimen.ayj));
                cVar.f307307a.setMaxWidth((int) dimension);
                if (cVar.f307311e.badgeIconDrawable != null) {
                    cVar.f307309c.setVisibility(0);
                    cVar.f307309c.setImageDrawable(cVar.f307311e.badgeIconDrawable);
                } else {
                    cVar.f307309c.setVisibility(8);
                }
                cVar.f307307a.setText(((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).createColorNickText(cVar.f307311e.label, 16));
                cVar.f307307a.setTextSize(2, 10.0f);
                ShareActionSheetBuilder.ActionSheetItem actionSheetItem = cVar.f307311e;
                if (actionSheetItem.iconNeedBg) {
                    Drawable drawable = actionSheetItem.iconDrawable;
                    if (drawable == null) {
                        drawable = this.f317462m.getDrawable(actionSheetItem.icon);
                    }
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int i18 = this.f317460h;
                    if (i18 > intrinsicWidth) {
                        i16 = (int) ((i18 - intrinsicWidth) / 2.0f);
                    } else {
                        i16 = 0;
                    }
                    if (i18 > intrinsicHeight) {
                        i17 = (int) ((i18 - intrinsicHeight) / 2.0f);
                    }
                    Drawable c16 = this.f317461i.c(drawable, i16, i17);
                    if (cVar.f307311e.enable) {
                        cVar.f307308b.setImageDrawable(this.f317461i.h(c16, this.f317461i.g(c16)));
                    } else {
                        cVar.f307308b.setImageDrawable(this.f317461i.f(c16));
                    }
                    cVar.f307308b.setBackground(null);
                } else {
                    int i19 = actionSheetItem.action;
                    if (i19 != 72 && i19 != 73) {
                        cVar.f307308b.setImageResource(R.drawable.f160037n);
                    } else {
                        cVar.f307308b.setImageResource(R.drawable.f160038mc);
                    }
                    a(cVar);
                    b(cVar);
                    ShareActionSheetV2 shareActionSheetV2 = this.f317457d;
                    if (shareActionSheetV2 != null && shareActionSheetV2.B0 != null) {
                        this.f317457d.B0.a(view, cVar.f307308b, cVar.f307307a, cVar.f307311e);
                    }
                }
                ShareActionSheetV2 shareActionSheetV22 = this.f317457d;
                if (shareActionSheetV22 != null && (param = shareActionSheetV22.f317428d) != null && (mVar = param.itemRender) != null) {
                    mVar.a(view, cVar.f307308b, cVar.f307307a, cVar.f307311e);
                }
                if (cVar.f307311e.isShowRedDot()) {
                    h(cVar);
                } else {
                    cVar.f307310d.setVisibility(8);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class MyResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ShareActionSheetV2> f317474d;

        public MyResultReceiver(ShareActionSheetV2 shareActionSheetV2) {
            super(new Handler(Looper.getMainLooper()));
            this.f317474d = new WeakReference<>(shareActionSheetV2);
        }

        private void a(List<ResultRecord> list) {
            ShareActionSheetV2 shareActionSheetV2 = this.f317474d.get();
            if (shareActionSheetV2 != null && shareActionSheetV2.f317452v0 != null) {
                shareActionSheetV2.f317452v0.a(list);
            }
        }

        private void b(List<ResultRecord> list) {
            if (list != null && !list.isEmpty()) {
                Iterator<ResultRecord> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().type == 10014) {
                        it.remove();
                    }
                }
            }
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            ShareActionSheetV2 shareActionSheetV2 = this.f317474d.get();
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetV2", 2, "shareActionSheetV2 " + shareActionSheetV2 + "onReceiveResult() called with: resultCode = [" + i3 + "], resultData = [" + bundle + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
            }
            if (shareActionSheetV2 != null && bundle != null) {
                bundle.setClassLoader(ShareActionSheetV2.class.getClassLoader());
                if (bundle.getInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO) == 2) {
                    if (i3 == -1) {
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(ISelectMemberActivityConstants.PARAM_RESULT_SET);
                        if (parcelableArrayList != null) {
                            Iterator it = parcelableArrayList.iterator();
                            while (it.hasNext()) {
                                ResultRecord resultRecord = (ResultRecord) it.next();
                                if (QLog.isColorLevel()) {
                                    QLog.iAsync("ShareActionSheetV2", 2, "onReceiveResult() called with: record = [" + resultRecord);
                                }
                            }
                        }
                        b(parcelableArrayList);
                        a(parcelableArrayList);
                        shareActionSheetV2.X(parcelableArrayList);
                        shareActionSheetV2.C = null;
                        return;
                    }
                    if (i3 == 100) {
                        shareActionSheetV2.C = (ResultReceiver) bundle.getParcelable("receiver");
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Param {
        public l actionSheetRender;
        public Context context;
        public Map<String, Object> deReportParams;
        public boolean flagNotTouchModal;
        public boolean fullScreen;
        public boolean isNotShowMyPc;
        public m itemRender;

        /* renamed from: lp, reason: collision with root package name */
        public ViewGroup.LayoutParams f317475lp;
        public int reportDataR2;
        public int reportDataR3;
        public float dimAmount = 0.5f;
        public boolean isCancelable = true;
        public boolean canceledOnTouchOutside = true;
        public boolean showBeforeGetRecentUser = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ActionSheet.OnDismissListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            ShareActionSheetV2.this.f317449s0.onDismiss(ShareActionSheetV2.this.F);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ShareActionSheetV2.this.F.isShowing()) {
                ShareActionSheetV2.this.F.cancel();
                ShareActionSheetV2.this.F.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            Object tag = view.getTag();
            if (tag instanceof ShareActionSheetBuilder.c) {
                ShareActionSheetBuilder.ActionSheetItem actionSheetItem = ((ShareActionSheetBuilder.c) tag).f307311e;
                int i16 = 1;
                if (QLog.isColorLevel()) {
                    QLog.i("ShareActionSheetV2", 2, String.format("onClick action=%s lis=%s lis2=%s", Integer.valueOf(actionSheetItem.action), ShareActionSheetV2.this.f317450t0, ShareActionSheetV2.this.f317451u0));
                }
                ShareActionSheetV2 shareActionSheetV2 = ShareActionSheetV2.this;
                if (adapterView == shareActionSheetV2.f317441l0) {
                    i16 = 0;
                } else if (adapterView != shareActionSheetV2.f317443m0) {
                    if (adapterView == shareActionSheetV2.f317444n0) {
                        i16 = 2;
                    } else {
                        i16 = -1;
                    }
                }
                shareActionSheetV2.c0(actionSheetItem, i16);
                ShareActionSheetV2.this.S(actionSheetItem);
                if (ShareActionSheetV2.this.f317450t0 != null) {
                    ShareActionSheetV2.this.f317450t0.onItemClick(actionSheetItem, ShareActionSheetV2.this);
                }
                if (ShareActionSheetV2.this.f317451u0 != null) {
                    ShareActionSheetV2.this.f317451u0.w6(view, actionSheetItem, ShareActionSheetV2.this);
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements com.tencent.mobileqq.armap.e {
        d() {
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            if (bitmap != null) {
                ShareActionSheetV2.this.W(str, str2, bitmap);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class f implements DialogInterface.OnDismissListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Map<String, Object> map;
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetV2", 2, "onDismiss() called with: dialog = [" + dialogInterface + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
            }
            ShareActionSheetV2.this.V();
            if (ShareActionSheetV2.this.E0 != null) {
                ShareActionSheetV2.this.E0.onDismiss(dialogInterface);
            }
            ShareActionSheetV2 shareActionSheetV2 = ShareActionSheetV2.this;
            Param param = shareActionSheetV2.f317428d;
            if (param != null && (map = param.deReportParams) != null) {
                shareActionSheetV2.f317432f.h(map);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g implements DialogInterface.OnShowListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            ShareActionSheetV2.this.D = false;
            if (ShareActionSheetV2.this.C0 != null) {
                ShareActionSheetV2.this.C0.onShow(dialogInterface);
            }
            ShareActionSheetV2.this.e0();
            ShareActionSheetV2.this.b0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class h implements ActionSheet.g {
        h() {
        }

        @Override // com.tencent.widget.ActionSheet.g
        public void b0(int i3) {
            ShareActionSheetV2.this.onConfigurationChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class i implements DialogInterface.OnCancelListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ShareActionSheetV2.this.V();
            if (ShareActionSheetV2.this.G0 != null) {
                ShareActionSheetV2.this.G0.onCancel(dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class j implements ActionSheet.WatchDismissActions {
        j() {
        }

        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public void onDismissOperations() {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetV2", 2, "onDismissOperations called with: dialog = [" + ShareActionSheetV2.this.F + "]");
            }
            if (ShareActionSheetV2.this.D0 != null) {
                ShareActionSheetV2.this.D0.onDismissOperations();
            }
            ShareActionSheetV2.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f317486a;

        /* renamed from: b, reason: collision with root package name */
        private View f317487b;

        protected k() {
        }

        private void a() {
            View view;
            if (this.f317486a != null && (view = this.f317487b) != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) this.f317487b.getParent()).removeView(this.f317487b);
                }
                this.f317486a.addView(this.f317487b);
            }
        }

        private void b(View view) {
            ViewParent parent;
            if (view != null && (parent = view.getParent()) != null && (parent instanceof ViewGroup)) {
                c((ViewGroup) parent);
            }
        }

        private void c(ViewGroup viewGroup) {
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        }

        public void d(RelativeLayout relativeLayout) {
            c(this.f317486a);
            c(relativeLayout);
            this.f317486a = relativeLayout;
            a();
        }

        void e(View view, RelativeLayout.LayoutParams layoutParams) {
            b(this.f317487b);
            b(view);
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            this.f317487b = view;
            a();
        }

        void f(int i3) {
            ViewGroup viewGroup = this.f317486a;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface l {
        void b(ActionSheet actionSheet);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface m {
        void a(View view, ImageView imageView, TextView textView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class n implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    ShareActionSheetV2.setViewAlpha(view, 1.0f);
                    return false;
                }
                return false;
            }
            ShareActionSheetV2.setViewAlpha(view, 0.5f);
            return false;
        }
    }

    @Deprecated
    public ShareActionSheetV2(Param param) {
        this.f317435h = false;
        this.f317428d = param;
        WeakReference<Context> weakReference = new WeakReference<>(param.context);
        this.f317430e = weakReference;
        Resources resources = weakReference.get().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158592jv);
        this.f317427c0 = dimensionPixelSize;
        this.f317431e0 = dimensionPixelSize;
        this.f317433f0 = resources.getDimensionPixelOffset(R.dimen.f158594jx);
        this.f317434g0 = resources.getDimensionPixelOffset(R.dimen.f158595jy);
        this.f317438i0 = new k();
        this.f317435h = param.showBeforeGetRecentUser;
        A(param.context);
        j0(resources, param);
        Y();
    }

    private void A(Context context) {
        if (context instanceof Activity) {
            return;
        }
        QLog.e("ShareActionSheetV2", 1, new IllegalArgumentException("Context is not instanceof Activity"), new Object[0]);
    }

    private void B() {
        int i3;
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            Param param = this.f317428d;
            if (param.fullScreen) {
                this.F = (ActionSheet) ActionSheetHelper.createFullScreenDialog(this.f317430e.get(), null);
            } else {
                if (param.flagNotTouchModal) {
                    i3 = R.layout.f167538iu;
                } else {
                    i3 = R.layout.action_sheet_base;
                }
                this.F = (ActionSheet) ActionSheetHelper.createDialog(this.f317430e.get(), null, i3, this.f317428d.f317475lp);
            }
            this.F.setOnShowListener(this.f317456z0);
            h0();
            this.F.setCancelable(this.f317428d.isCancelable);
            this.F.setOnCancelListener(this.F0);
            this.F.setOnWidthChangedListener(this.A0);
            if (this.G == null || this.f317425a0) {
                View C = C();
                this.G = C;
                if (C == null) {
                    return;
                }
            }
            ViewGroup rootView = this.F.getRootView();
            if (rootView != null) {
                rootView.setPadding(rootView.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(rootView.getContext()), rootView.getPaddingRight(), rootView.getPaddingBottom());
            }
            this.F.setActionContentView(this.G, null);
            Window window = this.F.getWindow();
            float f16 = this.f317428d.dimAmount;
            if (f16 == -1.0f) {
                if (rootView != null) {
                    rootView.setBackgroundColor(0);
                }
            } else {
                window.setDimAmount(f16);
            }
            window.setGravity(80);
            window.setLayout(-1, -1);
            this.F.setOutsideDismissEnableCompat(this.f317428d.canceledOnTouchOutside);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (this.f317428d.flagNotTouchModal) {
                window.setLayout(-1, -2);
            }
            if (this.f317428d.flagNotTouchModal) {
                window.setFlags(32, 32);
            }
            window.setAttributes(attributes);
            l lVar = this.f317428d.actionSheetRender;
            if (lVar != null) {
                lVar.b(this.F);
                return;
            }
            return;
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
    }

    private void D() {
        ResultReceiver resultReceiver = this.C;
        if (resultReceiver != null) {
            resultReceiver.send(1, new Bundle());
            this.C = null;
        }
    }

    private void E(boolean z16) {
        setOpenSource(null);
        if (isShowing()) {
            try {
                if (z16) {
                    this.F.superDismiss();
                } else {
                    this.F.dismissWithAnimationToken(R.anim.f154974uh);
                }
                this.G = null;
            } catch (RuntimeException e16) {
                QLog.w("ShareActionSheetV2", 2, "Exception while dismiss", e16);
            }
        }
    }

    private String H() {
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null && (this.f317430e.get() instanceof Activity)) {
            if (TextUtils.isEmpty(((Activity) this.f317430e.get()).getIntent().getStringExtra("url"))) {
                return "";
            }
            return "biz_src_general_url";
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
        return "";
    }

    private String K() {
        int i3;
        Param param = this.f317428d;
        if (param != null && (i3 = param.reportDataR2) > 0) {
            return String.valueOf(i3);
        }
        return "";
    }

    private String L() {
        int i3;
        Param param = this.f317428d;
        if (param != null && (i3 = param.reportDataR3) > 0) {
            return String.valueOf(i3);
        }
        return "";
    }

    private int M(List<ShareActionSheetBuilder.ActionSheetItem> list, TextView textView) {
        textView.setText(J(list));
        textView.measure(View.MeasureSpec.makeMeasureSpec(this.f317431e0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return textView.getMeasuredHeight();
    }

    private void O() {
        WeakReference<Context> weakReference = this.f317430e;
        boolean z16 = true;
        if (weakReference != null && weakReference.get() != null && (this.f317430e.get() instanceof Activity)) {
            Context context = this.f317430e.get();
            Bundle bundle = this.T;
            if (bundle == null || !bundle.getBoolean("no_need_report")) {
                z16 = false;
            }
            this.f317432f = new com.tencent.mobileqq.sharehelper.e(context, Boolean.valueOf(z16));
            HashMap hashMap = new HashMap();
            String stringExtra = ((Activity) this.f317430e.get()).getIntent().getStringExtra("big_brother_source_key");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = H();
            }
            hashMap.put("biz_source", stringExtra);
            this.f317432f.b("pg_qdesign_shareview", hashMap);
            this.f317432f.a(new ArrayList<String>() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetV2.4
                {
                    add("em_shareview_msg_icon_button");
                    add("em_shareview_more_button");
                    add("em_bas_save_as");
                    add("em_sgrp_share_item");
                    add("em_sgrp_share_panel_more_contacts");
                    add("em_share_item");
                }
            });
            d0(stringExtra);
            return;
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
    }

    private boolean P() {
        Bundle bundle = this.T;
        if (bundle == null || !bundle.getBoolean("is_force_night_theme", false)) {
            return false;
        }
        return true;
    }

    private boolean Q() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("share_actionsheet_memleak_8973_switch", false);
    }

    private boolean R(boolean z16, boolean z17, boolean z18) {
        if (z16 && this.f317453w0 != 8) {
            if (!z17 || this.f317454x0 == 8) {
                if (z18 && this.f317455y0 != 8) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        com.tencent.mobileqq.sharehelper.e eVar = this.f317432f;
        if (eVar == null) {
            QLog.e("ShareActionSheetV2", 1, "itemClickDaTongReport is error!");
            return;
        }
        int i3 = actionSheetItem.action;
        if (i3 == 64) {
            HashMap hashMap = new HashMap();
            hashMap.put("share_source", "6");
            this.f317432f.d("em_share_item", hashMap);
        } else if (i3 == 229) {
            eVar.c("em_bas_save_as");
        } else if (i3 == 73) {
            eVar.c("em_shareview_more_button");
        } else {
            if (i3 == 72) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("to_uin", actionSheetItem.uin);
                hashMap2.put("share_source", "1");
                hashMap2.put("share_user_source", Integer.valueOf(actionSheetItem.source));
                this.f317432f.d("em_shareview_msg_icon_button", hashMap2);
                HashMap hashMap3 = new HashMap();
                hashMap3.put(ShortVideoConstants.TO_UIN_TYPE, Integer.valueOf(actionSheetItem.uinType));
                if (actionSheetItem.uinType == 10027) {
                    hashMap3.put("sgrp_channel_id", actionSheetItem.uin);
                }
                this.f317432f.d("em_sgrp_share_panel_more_contacts", hashMap3);
                return;
            }
            if (i3 == 2) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("share_source", "1");
                this.f317432f.d("em_share_item", hashMap4);
            } else if (i3 == 9) {
                HashMap hashMap5 = new HashMap();
                hashMap5.put("share_source", "3");
                this.f317432f.d("em_share_item", hashMap5);
            }
        }
        HashMap hashMap6 = new HashMap();
        hashMap6.put("sgrp_btn_name", actionSheetItem.label);
        this.f317432f.d("em_sgrp_share_item", hashMap6);
    }

    private void T() {
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            D();
            Intent intent = new Intent();
            Intent intent2 = this.f317447q0;
            if (intent2 != null) {
                intent = intent2;
            }
            intent.putExtra("direct_send_if_dataline_forward", true);
            intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity");
            intent.putExtra("caller_name", this.f317430e.get().getClass().getSimpleName());
            intent.putExtra("forward_source_business_type", -1);
            intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 2);
            intent.putExtra("PARAM_ActivityResultReceiver", new MyResultReceiver(this));
            this.f317430e.get().startActivity(intent);
            if (this.f317430e.get() instanceof Activity) {
                ((Activity) this.f317430e.get()).overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
    }

    private boolean U() {
        if (this.f317453w0 != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called no need to load data");
            }
            return false;
        }
        if (this.f317447q0 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareActionSheetV2", 2, "needLoadRecentUser() called parameter illegal. Intent not set");
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "onDestroy() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        SparseArray<com.tencent.mobileqq.armap.f> sparseArray = this.f317448r0;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i3 = 0; i3 < this.f317448r0.size(); i3++) {
                com.tencent.mobileqq.armap.f fVar = this.f317448r0.get(this.f317448r0.keyAt(i3));
                if (fVar != null) {
                    fVar.destroy();
                }
            }
            this.f317448r0.clear();
        }
        D();
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, String str2, Bitmap bitmap) {
        for (int i3 = 0; i3 < this.f317441l0.getChildCount(); i3++) {
            Object tag = this.f317441l0.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof ShareActionSheetBuilder.c)) {
                ShareActionSheetBuilder.c cVar = (ShareActionSheetBuilder.c) tag;
                if (TextUtils.equals(str, cVar.f307311e.uin)) {
                    cVar.f307311e.iconDrawable = new BitmapDrawable(bitmap);
                    cVar.f307308b.setBackgroundDrawable(cVar.f307311e.iconDrawable);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(ArrayList<ResultRecord> arrayList) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "onRecentUserChanged() called with: recentUsers = [" + arrayList + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        this.X.clear();
        int i16 = 0;
        while (true) {
            if (arrayList == null || i16 >= arrayList.size()) {
                break;
            }
            if (i16 >= 15) {
                ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(73);
                build.iconNeedBg = false;
                build.iconDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.dgc);
                this.X.add(build);
                break;
            }
            ResultRecord resultRecord = arrayList.get(i16);
            if (AppConstants.DATALINE_NEW_VERSION_UIN.equals(resultRecord.uin) && !com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
                QLog.d("QfileAssistant", 1, "shareActionSheetV2 error, onRecentUserChanged: ", new Exception());
            } else if (!AppConstants.DATALINE_IPAD_UIN.equals(resultRecord.uin) && !AppConstants.DATALINE_PHONE_UIN.equals(resultRecord.uin)) {
                ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(72);
                build2.label = resultRecord.name;
                build2.uin = resultRecord.uin;
                build2.guildId = resultRecord.guildId;
                build2.uinType = resultRecord.type;
                build2.iconNeedBg = false;
                build2.argus = "isNewTroop=" + (resultRecord.isNewTroop ? 1 : 0);
                build2.source = resultRecord.source;
                int i17 = build2.uinType;
                if (i17 == 10014 || i17 == 10027) {
                    Context context = this.f317430e.get();
                    if (QQTheme.isNowThemeIsNight()) {
                        i3 = R.drawable.jns;
                    } else {
                        i3 = R.drawable.jnr;
                    }
                    if (context != null) {
                        build2.badgeIconDrawable = context.getDrawable(i3);
                    }
                }
                if (6000 == build2.uinType && TextUtils.equals(AppConstants.DATALINE_PC_UIN, build2.uin)) {
                    if (!this.f317428d.isNotShowMyPc) {
                        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(26);
                        build2.label = build3.label;
                        build2.reportID = build3.reportID;
                        build2.iconNeedBg = false;
                        build2.icon = R.drawable.qfile_dataline_pc_recent;
                        if (QQTheme.isNowSimpleUI()) {
                            build2.icon = R.drawable.hti;
                        }
                        if (QQTheme.isNowThemeIsNight() || P()) {
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            paint.setColor(QQTheme.NIGHTMODE_MASKCOLOR);
                            try {
                                Bitmap copy = BitmapFactory.decodeResource(this.f317430e.get().getResources(), build2.icon).copy(Bitmap.Config.ARGB_8888, true);
                                Canvas canvas = new Canvas(copy);
                                if (QQTheme.isNowSimpleUI()) {
                                    canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), 10.0f, 10.0f, paint);
                                } else {
                                    canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getWidth() / 2, paint);
                                }
                                build2.iconDrawable = new BitmapDrawable(copy);
                            } catch (Throwable th5) {
                                QLog.e("ShareActionSheetV2", 1, "onRecentUserChanged: no night mode mask", th5);
                            }
                        }
                    }
                }
                this.X.add(build2);
            }
            i16++;
        }
        if (this.f317435h) {
            refresh();
        } else {
            B();
            m0(true);
        }
    }

    private void Y() {
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            if (Q()) {
                return;
            }
            ((Application) this.f317430e.get().getApplicationContext()).registerActivityLifecycleCallbacks(this.E);
            return;
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
    }

    private void Z() {
        this.H = null;
        this.I = null;
        this.J = null;
        this.P = null;
    }

    private void a0() {
        List<ShareActionSheetBuilder.ActionSheetItem>[] listArr;
        ArrayList arrayList;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("share_action_remove_shortvideo_revert", false) || (listArr = this.W) == null) {
            return;
        }
        ArrayList[] arrayListArr = new ArrayList[listArr.length];
        for (int i3 = 0; i3 < listArr.length; i3++) {
            List<ShareActionSheetBuilder.ActionSheetItem> list = listArr[i3];
            if (list != null) {
                arrayList = new ArrayList();
                for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : list) {
                    int i16 = actionSheetItem.action;
                    if (i16 != 203 && i16 != 184) {
                        arrayList.add(actionSheetItem);
                    }
                }
            } else {
                arrayList = null;
            }
            arrayListArr[i3] = arrayList;
        }
        this.W = arrayListArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        Map<String, Object> map;
        O();
        com.tencent.mobileqq.sharehelper.e eVar = this.f317432f;
        if (eVar == null) {
            QLog.e("ShareActionSheetV2", 1, "reportActionSheetExpose is error!");
            return;
        }
        Param param = this.f317428d;
        if (param != null) {
            map = param.deReportParams;
        } else {
            map = null;
        }
        eVar.g(map);
        List<ShareActionSheetBuilder.ActionSheetItem> list = this.X;
        if (list != null && !list.isEmpty()) {
            Iterator<ShareActionSheetBuilder.ActionSheetItem> it = this.X.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().action == 73) {
                        this.f317432f.e("em_shareview_more_button");
                        break;
                    }
                } else {
                    break;
                }
            }
            List<ShareActionSheetBuilder.ActionSheetItem>[] listArr = this.W;
            if (listArr.length > 0) {
                for (ShareActionSheetBuilder.ActionSheetItem actionSheetItem : listArr[0]) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("sgrp_btn_name", actionSheetItem.label);
                    this.f317432f.f("em_sgrp_share_item", hashMap);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, int i3) {
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference == null) {
            QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
            return;
        }
        String stringExtra = ((Activity) weakReference.get()).getIntent().getStringExtra("big_brother_source_key");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = H();
        }
        String str = stringExtra;
        int i16 = actionSheetItem.action;
        if (i16 == 73) {
            ReportController.o(null, "dc00898", "", "", "0X800AB3F", "0X800AB3F", 0, 0, K(), L(), str, "");
            return;
        }
        if (i16 == 72) {
            ReportController.o(null, "dc00898", "", actionSheetItem.uin, "0X800AB3E", "0X800AB3E", 0, 0, K(), L(), str, actionSheetItem.reportID);
        } else if (i3 == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800AB40", "0X800AB40", 0, 0, K(), L(), str, actionSheetItem.reportID);
        } else if (i3 == 2) {
            ReportController.o(null, "dc00898", "", "", "0X800AB41", "0X800AB41", 0, 0, K(), L(), str, actionSheetItem.reportID);
        }
    }

    private void d0(String str) {
        List<ShareActionSheetBuilder.ActionSheetItem>[] F = F();
        if (F.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(F[0]);
        if (F.length == 2) {
            arrayList.addAll(F[1]);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int a16 = fe.a(((ShareActionSheetBuilder.ActionSheetItem) it.next()).action);
            if (a16 >= 0) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("biz_source", str);
                hashMap2.put("pgid", "pg_qdesign_shareview");
                hashMap.put("cur_pg", hashMap2);
                hashMap.put("share_source", Integer.valueOf(a16));
                hashMap.put("pgid", "pg_qdesign_shareview");
                hashMap.put("eid", "em_share_item");
                VideoReport.reportEvent("dt_imp", hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null && (this.f317430e.get() instanceof Activity)) {
            String stringExtra = ((Activity) this.f317430e.get()).getIntent().getStringExtra("big_brother_source_key");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = H();
            }
            String str = stringExtra;
            StringBuilder sb5 = new StringBuilder();
            List<ShareActionSheetBuilder.ActionSheetItem>[] F = F();
            if (F.length > 0) {
                for (int i3 = 0; i3 < F[0].size(); i3++) {
                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = F[0].get(i3);
                    if (i3 != 0) {
                        sb5.append(';');
                    }
                    sb5.append(actionSheetItem.reportID);
                }
            }
            ReportController.o(null, "dc00898", "", "", "0X800AB3D", "0X800AB3D", 0, 0, K(), L(), str, sb5.toString());
            return;
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
    }

    private void f0() {
        WeakReference<Context> weakReference;
        if (this.M != null && (weakReference = this.f317430e) != null && weakReference.get() != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.M.getLayoutParams();
            layoutParams.bottomMargin = this.f317430e.get().getResources().getDimensionPixelOffset(R.dimen.c_8);
            layoutParams.topMargin = this.f317430e.get().getResources().getDimensionPixelOffset(R.dimen.c9y);
            this.M.setLayoutParams(layoutParams);
        }
    }

    private void g0() {
        this.L.setTextSize(1, 14.0f);
        this.L.setTypeface(Typeface.DEFAULT_BOLD);
    }

    private void h0() {
        this.F.registerWatchDisMissActionListener(new j());
        this.F.setOnDismissListener(new a());
    }

    private void i0(View view, boolean z16) {
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.bmt);
        if (!z16) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = ViewUtils.dip2px(21.0f);
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackground(view.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
    }

    private void j0(Resources resources, Param param) {
        setIconMarginLeftRight(resources.getDimensionPixelOffset(R.dimen.c7a));
        setRowMarginLeftRight(resources.getDimensionPixelOffset(R.dimen.c7b));
    }

    private void k0() {
        int i3;
        ArrayList parcelableArrayList = getExtras().getParcelableArrayList("key_share_match_friends");
        TextView textView = this.L;
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            i3 = R.string.f227496r7;
        } else {
            i3 = R.string.f227506r8;
        }
        textView.setText(i3);
        for (int i16 = 0; i16 < parcelableArrayList.size(); i16++) {
            if (i16 >= 15) {
                ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(73);
                build.iconNeedBg = false;
                Resources resources = BaseApplication.getContext().getResources();
                if (QQTheme.isNowSimpleUI()) {
                    build.iconDrawable = resources.getDrawable(R.drawable.dgd);
                } else {
                    build.iconDrawable = resources.getDrawable(R.drawable.dgc);
                }
                this.Z.add(build);
                return;
            }
            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(198);
            ResultRecord resultRecord = (ResultRecord) parcelableArrayList.get(i16);
            build2.label = resultRecord.name;
            build2.uin = resultRecord.uin;
            build2.uinType = resultRecord.type;
            build2.matchFriendAvatarUrl = resultRecord.matchFriendAvatarUrl;
            build2.iconNeedBg = false;
            this.Z.add(build2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(ElasticHorScrView elasticHorScrView, int i3, int i16) {
        if (elasticHorScrView == null) {
            QLog.e("ShareActionSheetV2", 1, "setMoveIfNecessary fail, horScrView is null");
        } else if (i3 < i16) {
            elasticHorScrView.setMove(true);
        } else {
            elasticHorScrView.setMove(false);
        }
    }

    private void m0(boolean z16) {
        try {
            if (!isShowing()) {
                if (getWindow() != null) {
                    com.tencent.mobileqq.theme.a.d(getWindow());
                }
                if (this.f317445o0) {
                    com.tencent.biz.subscribe.utils.g.b(getWindow());
                }
                if (this.G != null) {
                    this.F.show(z16, R.anim.f154977uk);
                }
                if (this.f317445o0) {
                    com.tencent.biz.subscribe.utils.g.c(getWindow());
                    com.tencent.biz.subscribe.utils.g.a(getWindow());
                }
            }
        } catch (Exception e16) {
            N(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            if (Q()) {
                return;
            }
            ((Application) this.f317430e.get().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.E);
            return;
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
    }

    public static void setViewAlpha(View view, float f16) {
        view.setAlpha(f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(9)
    public View C() {
        List<ShareActionSheetBuilder.ActionSheetItem> arrayList;
        List<ShareActionSheetBuilder.ActionSheetItem> arrayList2;
        List<ShareActionSheetBuilder.ActionSheetItem> arrayList3;
        boolean z16;
        int i3;
        List<ShareActionSheetBuilder.ActionSheetItem> list;
        boolean z17;
        int i16;
        View a16;
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "createViewFlipper() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            try {
                View inflate = View.inflate(this.f317430e.get(), I(), null);
                this.f317438i0.d((RelativeLayout) inflate.findViewById(R.id.f2104if));
                this.f317439j0 = inflate.findViewById(R.id.s_6);
                this.N = (LinearLayout) inflate.findViewById(G());
                boolean z18 = this.f317426b0;
                this.M = (LinearLayout) inflate.findViewById(R.id.s_5);
                f0();
                TextView textView = (TextView) inflate.findViewById(R.id.f163933cv);
                this.L = textView;
                if (this.f317440k0) {
                    textView.setVisibility(0);
                    CharSequence charSequence = this.V;
                    if (charSequence != null) {
                        this.L.setText(charSequence);
                    }
                } else {
                    hideTitle();
                }
                g0();
                this.H = (ElasticHorScrView) inflate.findViewById(R.id.ieo);
                this.I = (ElasticHorScrView) inflate.findViewById(R.id.iih);
                this.J = (ElasticHorScrView) inflate.findViewById(R.id.iii);
                this.K = (LinearLayout) inflate.findViewById(R.id.s9z);
                a0();
                List<ShareActionSheetBuilder.ActionSheetItem>[] F = F();
                if (F.length > 0) {
                    if (getExtras() != null && getExtras().getBoolean("key_share_to_expand", false)) {
                        arrayList = this.Y;
                        arrayList.clear();
                        Iterator it = getExtras().getParcelableArrayList("key_share_expand_friends").iterator();
                        while (it.hasNext()) {
                            ResultRecord resultRecord = (ResultRecord) it.next();
                            if (AppConstants.DATALINE_NEW_VERSION_UIN.equals(resultRecord.uin) && !com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
                                QLog.d("QfileAssistant", 1, "shareActionSheetV2 error, createViewFlipper: ", new Exception());
                            } else {
                                ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(178);
                                build.label = resultRecord.name;
                                build.uin = resultRecord.uin;
                                build.uinType = resultRecord.type;
                                build.iconNeedBg = false;
                                this.Y.add(build);
                            }
                        }
                    } else if (getExtras() != null && getExtras().getBoolean("key_share_to_match_friend", false)) {
                        arrayList = this.Z;
                        arrayList.clear();
                        k0();
                    } else {
                        arrayList = this.X;
                    }
                } else {
                    arrayList = new ArrayList<>(0);
                }
                if (arrayList.isEmpty()) {
                    z18 = false;
                }
                if (F.length > 0) {
                    arrayList2 = F[0];
                } else {
                    arrayList2 = new ArrayList<>(0);
                }
                boolean z19 = !arrayList2.isEmpty();
                if (F.length > 1) {
                    arrayList3 = F[1];
                } else {
                    arrayList3 = new ArrayList<>(0);
                }
                boolean z26 = !arrayList3.isEmpty();
                TextView textView2 = (TextView) LayoutInflater.from(this.f317430e.get()).inflate(R.layout.aot, (ViewGroup) null);
                textView2.setTextSize(2, 10.0f);
                textView2.setLayoutParams(new ViewGroup.LayoutParams(this.f317431e0, -2));
                int M = M(arrayList, textView2);
                int M2 = M(arrayList2, textView2);
                int M3 = M(arrayList3, textView2);
                Math.max(Math.max(M, M2), M3);
                int dimensionPixelOffset = this.f317430e.get().getResources().getDimensionPixelOffset(R.dimen.c79);
                boolean R = R(z18, z19, z26);
                if (z18) {
                    this.f317441l0 = (GridView) inflate.findViewById(R.id.fjr);
                    this.H.setOverScrollMode(2);
                    Iterator<ShareActionSheetBuilder.ActionSheetItem> it5 = arrayList.iterator();
                    int i17 = 0;
                    while (it5.hasNext()) {
                        if (it5.next().visibility == 0) {
                            i17++;
                        }
                    }
                    int iconWidth = this.f317429d0 + getIconWidth() + this.f317429d0;
                    this.f317441l0.setColumnWidth(iconWidth);
                    this.f317441l0.setNumColumns(i17);
                    ViewGroup.LayoutParams layoutParams = this.f317441l0.getLayoutParams();
                    z16 = z18;
                    GridView gridView = this.f317441l0;
                    i3 = M3;
                    list = arrayList3;
                    z17 = z26;
                    i16 = dimensionPixelOffset;
                    gridView.setPadding(this.f317436h0, gridView.getPaddingTop(), this.f317436h0, this.f317441l0.getPaddingBottom());
                    int i18 = this.f317436h0;
                    int i19 = (i17 * iconWidth) + i18 + i18;
                    layoutParams.width = i19;
                    this.Q = i19;
                    int dip2px = ViewUtils.dip2px(19.0f);
                    if (!R) {
                        dip2px = i16;
                    }
                    layoutParams.height = this.f317427c0 + this.f317433f0 + M + dip2px;
                    this.f317441l0.setLayoutParams(layoutParams);
                    this.f317441l0.setAdapter((ListAdapter) new ActionSheetItemAdapter(this.f317430e.get(), arrayList, this, false));
                    this.f317441l0.setSelector(new ColorDrawable(0));
                    this.f317441l0.setOnItemClickListener(this.f317437i);
                } else {
                    z16 = z18;
                    i3 = M3;
                    list = arrayList3;
                    z17 = z26;
                    i16 = dimensionPixelOffset;
                }
                i0(inflate, R);
                if (z19) {
                    this.f317443m0 = (GridView) inflate.findViewById(R.id.f165392cx3);
                    this.I.setOverScrollMode(2);
                    Iterator<ShareActionSheetBuilder.ActionSheetItem> it6 = arrayList2.iterator();
                    int i26 = 0;
                    while (it6.hasNext()) {
                        if (it6.next().visibility == 0) {
                            i26++;
                        }
                    }
                    int iconWidth2 = this.f317429d0 + getIconWidth() + this.f317429d0;
                    this.f317443m0.setColumnWidth(iconWidth2);
                    this.f317443m0.setNumColumns(i26);
                    ViewGroup.LayoutParams layoutParams2 = this.f317443m0.getLayoutParams();
                    GridView gridView2 = this.f317443m0;
                    gridView2.setPadding(this.f317436h0, gridView2.getPaddingTop(), this.f317436h0, this.f317443m0.getPaddingBottom());
                    int i27 = this.f317436h0;
                    int i28 = (i26 * iconWidth2) + i27 + i27;
                    layoutParams2.width = i28;
                    this.R = i28;
                    layoutParams2.height = this.f317427c0 + this.f317433f0 + M2 + i16;
                    this.f317443m0.setLayoutParams(layoutParams2);
                    this.f317443m0.setAdapter((ListAdapter) new ActionSheetItemAdapter(this.f317430e.get(), arrayList2, this, false));
                    this.f317443m0.setSelector(new ColorDrawable(0));
                    this.f317443m0.setOnItemClickListener(this.f317437i);
                }
                if (z17) {
                    this.f317444n0 = (GridView) inflate.findViewById(R.id.cx4);
                    this.J.setOverScrollMode(2);
                    this.f317444n0.setSmoothScrollbarEnabled(false);
                    Iterator<ShareActionSheetBuilder.ActionSheetItem> it7 = list.iterator();
                    int i29 = 0;
                    while (it7.hasNext()) {
                        if (it7.next().visibility == 0) {
                            i29++;
                        }
                    }
                    int iconWidth3 = this.f317429d0 + getIconWidth() + this.f317429d0;
                    this.f317444n0.setColumnWidth(iconWidth3);
                    this.f317444n0.setNumColumns(i29);
                    ViewGroup.LayoutParams layoutParams3 = this.f317444n0.getLayoutParams();
                    GridView gridView3 = this.f317444n0;
                    gridView3.setPadding(this.f317436h0, gridView3.getPaddingTop(), this.f317436h0, this.f317444n0.getPaddingBottom());
                    int i36 = this.f317436h0;
                    int i37 = (iconWidth3 * i29) + i36 + i36;
                    layoutParams3.width = i37;
                    this.S = i37;
                    layoutParams3.height = this.f317427c0 + this.f317433f0 + i3 + i16;
                    this.f317444n0.setLayoutParams(layoutParams3);
                    this.f317444n0.setNumColumns(i29);
                    this.f317444n0.setAdapter((ListAdapter) new ActionSheetItemAdapter(this.f317430e.get(), list, this, true));
                    this.f317444n0.setSelector(new ColorDrawable(0));
                    this.f317444n0.setOnItemClickListener(this.f317437i);
                }
                ImageView imageView = (ImageView) inflate.findViewById(R.id.f163928co);
                this.P = imageView;
                imageView.setOnClickListener(this.H0);
                this.P.setOnTouchListener(I0);
                if (!z16 || this.f317453w0 == 8) {
                    this.H.setVisibility(8);
                }
                if (!z19 || this.f317454x0 == 8) {
                    this.I.setVisibility(8);
                }
                if (!z17 || this.f317455y0 == 8) {
                    this.J.setVisibility(8);
                }
                inflate.post(new Runnable() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetV2.12
                    @Override // java.lang.Runnable
                    public void run() {
                        ShareActionSheetV2 shareActionSheetV2 = ShareActionSheetV2.this;
                        ElasticHorScrView elasticHorScrView = shareActionSheetV2.H;
                        if (elasticHorScrView != null) {
                            shareActionSheetV2.l0(elasticHorScrView, elasticHorScrView.getWidth(), ShareActionSheetV2.this.Q);
                        }
                        ShareActionSheetV2 shareActionSheetV22 = ShareActionSheetV2.this;
                        ElasticHorScrView elasticHorScrView2 = shareActionSheetV22.I;
                        if (elasticHorScrView2 != null) {
                            shareActionSheetV22.l0(elasticHorScrView2, elasticHorScrView2.getWidth(), ShareActionSheetV2.this.R);
                        }
                        ShareActionSheetV2 shareActionSheetV23 = ShareActionSheetV2.this;
                        ElasticHorScrView elasticHorScrView3 = shareActionSheetV23.J;
                        if (elasticHorScrView3 != null) {
                            shareActionSheetV23.l0(elasticHorScrView3, elasticHorScrView3.getWidth(), ShareActionSheetV2.this.S);
                        }
                    }
                });
                ShareActionSheet.b bVar = this.U;
                if (bVar != null && (a16 = bVar.a()) != null) {
                    if (a16.getParent() != null) {
                        ((ViewGroup) a16.getParent()).removeView(a16);
                    }
                    this.K.addView(a16);
                }
                return inflate;
            } catch (Exception e16) {
                QLog.d("ShareActionSheetV2", 1, "createViewFlipper() Exception=" + e16);
                return null;
            }
        }
        QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ShareActionSheetBuilder.ActionSheetItem>[] F() {
        List<ShareActionSheetBuilder.ActionSheetItem>[] listArr = this.W;
        if (listArr != null) {
            return listArr;
        }
        return new ArrayList[0];
    }

    protected int G() {
        return R.id.f163935cx;
    }

    protected int I() {
        return R.layout.aou;
    }

    protected String J(List<ShareActionSheetBuilder.ActionSheetItem> list) {
        String str = "";
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str2 = list.get(i3).label;
            if (str2.length() > str.length()) {
                str = str2;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(Exception exc) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "actionSheet.show exception=" + exc);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismiss() {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "dismiss() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        E(false);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismissImmediately() {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "dismissImmediately() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        E(true);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public View findViewById(int i3) {
        Window window;
        ActionSheet actionSheet = this.F;
        if (actionSheet == null || (window = actionSheet.getWindow()) == null) {
            return null;
        }
        return window.findViewById(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public ActionSheet getActionSheet() {
        return this.F;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getActionSheetPanelViewHeight() {
        View view = this.f317439j0;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Bundle getExtras() {
        return this.T;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getIconWidth() {
        return this.f317427c0;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public String getOpenSource() {
        return this.f317446p0;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Window getWindow() {
        ActionSheet actionSheet = this.F;
        if (actionSheet == null) {
            return null;
        }
        return actionSheet.getWindow();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void hideTitle() {
        this.f317440k0 = false;
        TextView textView = this.L;
        if (textView != null && textView.getVisibility() != 8) {
            this.L.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public boolean isShowing() {
        ActionSheet actionSheet = this.F;
        if (actionSheet != null && actionSheet.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void onConfigurationChanged() {
        View view;
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference == null || weakReference.get() == null || !isShowing() || (view = this.G) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetV2.13
            @Override // java.lang.Runnable
            public void run() {
                ShareActionSheetV2 shareActionSheetV2 = ShareActionSheetV2.this;
                ElasticHorScrView elasticHorScrView = shareActionSheetV2.H;
                if (elasticHorScrView != null) {
                    shareActionSheetV2.l0(elasticHorScrView, elasticHorScrView.getWidth(), ShareActionSheetV2.this.Q);
                }
                ShareActionSheetV2 shareActionSheetV22 = ShareActionSheetV2.this;
                ElasticHorScrView elasticHorScrView2 = shareActionSheetV22.I;
                if (elasticHorScrView2 != null) {
                    shareActionSheetV22.l0(elasticHorScrView2, elasticHorScrView2.getWidth(), ShareActionSheetV2.this.R);
                }
                ShareActionSheetV2 shareActionSheetV23 = ShareActionSheetV2.this;
                ElasticHorScrView elasticHorScrView3 = shareActionSheetV23.J;
                if (elasticHorScrView3 != null) {
                    shareActionSheetV23.l0(elasticHorScrView3, elasticHorScrView3.getWidth(), ShareActionSheetV2.this.S);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void refresh() {
        ActionSheet actionSheet = this.F;
        if (actionSheet != null && actionSheet.isShowing()) {
            View C = C();
            this.G = C;
            if (C == null) {
                return;
            }
            this.F.setActionContentView(C, null);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] listArr) {
        this.W = listArr;
        this.f317425a0 = true;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetTitle(CharSequence charSequence) {
        this.V = charSequence;
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvBgColor(int i3) {
        this.f317438i0.f(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvView(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f317438i0.e(view, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setBottomBarInterface(ShareActionSheet.b bVar) {
        this.U = bVar;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "setCancelListener() called with: listener = [" + onCancelListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        this.G0 = onCancelListener;
    }

    public void setClickCancelBtnListener(View.OnClickListener onClickListener) {
        this.H0 = onClickListener;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setEnableNotTriggerVirtualNavigationBar(boolean z16) {
        this.f317445o0 = z16;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setExtras(Bundle bundle) {
        this.T = bundle;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIconMarginLeftRight(int i3) {
        this.f317429d0 = i3;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIntentForStartForwardRecentActivity(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "setIntentForStartForwardRecentActivity() called with: intent = [" + intent + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        this.f317447q0 = intent;
    }

    public void setIsShowRecentFriends(boolean z16) {
        this.f317426b0 = z16;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener onItemClickListener) {
        this.f317450t0 = onItemClickListener;
        this.f317425a0 = true;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV3(ShareActionSheet.c cVar) {
        this.f317451u0 = cVar;
        this.f317425a0 = true;
    }

    public void setItemRender(m mVar) {
        this.B0 = mVar;
        this.f317425a0 = true;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "setOnDismissListener() called with: dismissListener = [" + onDismissListener + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        this.E0 = onDismissListener;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.C0 = onShowListener;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOpenSource(String str) {
        this.f317446p0 = str;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRecentlyUserSorter(ShareActionSheet.a aVar) {
        this.f317452v0 = aVar;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowMarginLeftRight(int i3) {
        this.f317436h0 = i3;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowVisibility(int i3, int i16, int i17) {
        this.f317453w0 = i3;
        this.f317454x0 = i16;
        this.f317455y0 = i17;
    }

    public void setWatchDismissListener(ActionSheet.WatchDismissActions watchDismissActions) {
        this.D0 = watchDismissActions;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void show() {
        show(true);
    }

    public void show(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "show() called #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
        if (!this.D && !isShowing()) {
            this.D = true;
            if (U()) {
                if (this.f317435h) {
                    B();
                    m0(z16);
                }
                T();
                return;
            }
            B();
            m0(z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetV2", 2, "show() isShowing #this = " + Integer.toHexString(System.identityHashCode(this)));
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> list, List<ShareActionSheetBuilder.ActionSheetItem> list2) {
        setActionSheetItems(new ArrayList[]{(ArrayList) list, (ArrayList) list2});
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUI() {
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUIIfShowing() {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements Application.ActivityLifecycleCallbacks {
        e() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (ShareActionSheetV2.this.f317430e == null) {
                QLog.e("ShareActionSheetV2", 1, "context_weak_ref is null");
                return;
            }
            QLog.i("ShareActionSheetV2", 1, "[mActivityLifecycleCallback]onActivityDestroyed,activity=" + activity + ",mContext=" + ShareActionSheetV2.this.f317430e.get());
            if (activity == ShareActionSheetV2.this.f317430e.get()) {
                ShareActionSheetV2.this.n0();
                ShareActionSheetV2.this.V();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
    }
}
