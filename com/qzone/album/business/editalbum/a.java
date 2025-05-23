package com.qzone.album.business.editalbum;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PublicShareCacheData;
import com.qzone.album.data.model.SharingAlbumClientAttr;
import com.qzone.album.ui.widget.AlbumDialog;
import com.qzone.album.ui.widget.e;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.album.util.q;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.module.feedcomponent.view.AvatarImageView;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends BaseAdapter {
    private ArrayList<SharingAlbumClientAttr> C;
    private View.OnClickListener D;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private ActionSheet L;
    ActionMenuItem M;
    ActionMenuItem N;
    ActionMenuItem P;
    ActionMenuItem Q;
    ActionMenuItem R;

    /* renamed from: e, reason: collision with root package name */
    private AlbumCacheData f42509e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f42510f;

    /* renamed from: h, reason: collision with root package name */
    private int f42511h;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f42512i;

    /* renamed from: d, reason: collision with root package name */
    private final String f42508d = "SharingOwnersGridAdapter";
    private int E = 0;
    private int K = -1;
    private ActionSheet.OnButtonClickListener S = new b();

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<SharingAlbumClientAttr> f42513m = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        SharingAlbumClientAttr f42523d;

        /* renamed from: e, reason: collision with root package name */
        int f42524e;

        c(SharingAlbumClientAttr sharingAlbumClientAttr, int i3) {
            this.f42523d = sharingAlbumClientAttr;
            this.f42524e = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0216, code lost:
        
            if (r12.f42525f.K != 12) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x02d6, code lost:
        
            if (r12.f42525f.K != 12) goto L63;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0316  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.f42509e != null) {
                if (a.this.K == -1) {
                    a aVar = a.this;
                    aVar.K = aVar.f42509e.albumtype;
                }
                SharingAlbumClientAttr sharingAlbumClientAttr = this.f42523d;
                boolean z16 = false;
                if (sharingAlbumClientAttr == null) {
                    a.this.P.setTag("clientAttr", sharingAlbumClientAttr);
                    a.this.P.setTag("position", Integer.valueOf(this.f42524e));
                    a.this.Q.setTag("clientAttr", this.f42523d);
                    a.this.Q.setTag("position", Integer.valueOf(this.f42524e));
                    a.this.R.setTag("clientAttr", this.f42523d);
                    a.this.R.setTag("position", Integer.valueOf(this.f42524e));
                    a.this.M.setVisibility(8);
                    a.this.P.setVisibility(0);
                    a.this.Q.setVisibility(0);
                    if (a.this.K == 12) {
                        a.this.R.setVisibility(0);
                    } else {
                        a.this.R.setVisibility(8);
                    }
                    a.this.N.setVisibility(8);
                    a.this.n();
                    ActionSheetHelper.showActionSheet(a.this.f42510f, a.this.L);
                } else if (sharingAlbumClientAttr.uin == 0) {
                    if (a.this.f42509e.getSharingOwnersNumber() >= a.this.f42509e.getMaxCount()) {
                        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumToastNotExceed", "\u5c0f\u5bb6\u5ead\u5927\u5feb\u4e50\uff0c\u4e0d\u8981\u8d85\u8fc7");
                        u4.a.z().s0(config + a.this.f42509e.getMaxCount() + l.a(R.string.tfl));
                    } else {
                        com.qzone.album.env.common.a.m().P(402, 4, "1", true, a.this.f42509e.albumid);
                        com.qzone.album.env.common.a.m().z(a.this.f42510f, this.f42524e, 13);
                    }
                } else {
                    a.this.M.setTag("clientAttr", sharingAlbumClientAttr);
                    a.this.M.setTag("position", Integer.valueOf(this.f42524e));
                    a.this.N.setTag("clientAttr", this.f42523d);
                    a.this.N.setTag("position", Integer.valueOf(this.f42524e));
                    a.this.P.setTag("clientAttr", this.f42523d);
                    a.this.P.setTag("position", Integer.valueOf(this.f42524e));
                    a.this.Q.setTag("clientAttr", this.f42523d);
                    a.this.Q.setTag("position", Integer.valueOf(this.f42524e));
                    a.this.R.setTag("clientAttr", this.f42523d);
                    a.this.R.setTag("position", Integer.valueOf(this.f42524e));
                    if (!a.this.f42509e.isSharingAlbumCreator()) {
                        if (!a.this.f42509e.isUnsharingAlbumCreator()) {
                            if (a.this.f42509e.isSharingAlbumPartner()) {
                                if (this.f42523d.uin != a.this.f42509e.createSharingUin && this.f42523d.uin == com.qzone.album.env.common.a.m().s()) {
                                    if (a.this.K != 8) {
                                        if (a.this.K != 9) {
                                            if (a.this.K != 11) {
                                            }
                                        }
                                    } else {
                                        a.this.M.setVisibility(0);
                                        a.this.P.setVisibility(8);
                                        a.this.Q.setVisibility(8);
                                        a.this.R.setVisibility(8);
                                        a.this.N.setVisibility(8);
                                    }
                                }
                            }
                            z16 = true;
                        }
                        a.this.n();
                        ActionSheet actionSheet = a.this.L;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(l.a(R.string.tfh));
                        a aVar2 = a.this;
                        sb5.append(aVar2.p(aVar2.f42509e, this.f42524e));
                        sb5.append(l.a(R.string.tff));
                        actionSheet.setMainTitle(sb5.toString());
                        if (z16) {
                        }
                    } else {
                        if (this.f42523d.uin == a.this.f42509e.createSharingUin) {
                            if (a.this.K != 8) {
                                if (a.this.K != 9) {
                                    if (a.this.K != 11) {
                                    }
                                }
                                a.this.n();
                                ActionSheet actionSheet2 = a.this.L;
                                StringBuilder sb52 = new StringBuilder();
                                sb52.append(l.a(R.string.tfh));
                                a aVar22 = a.this;
                                sb52.append(aVar22.p(aVar22.f42509e, this.f42524e));
                                sb52.append(l.a(R.string.tff));
                                actionSheet2.setMainTitle(sb52.toString());
                                if (z16) {
                                    ActionSheetHelper.showActionSheet(a.this.f42510f, a.this.L);
                                }
                            } else {
                                a.this.M.setVisibility(0);
                                a.this.P.setVisibility(8);
                                a.this.Q.setVisibility(8);
                                a.this.R.setVisibility(8);
                                a.this.N.setVisibility(8);
                            }
                        } else {
                            if (a.this.K == 8) {
                                a.this.M.setVisibility(0);
                            } else {
                                a.this.M.setVisibility(8);
                            }
                            SharingAlbumClientAttr sharingAlbumClientAttr2 = this.f42523d;
                            if (sharingAlbumClientAttr2.uinAttr.status == 1) {
                                boolean z17 = sharingAlbumClientAttr2.needShowResend;
                            }
                            a.this.N.setVisibility(0);
                            a.this.P.setVisibility(8);
                            a.this.Q.setVisibility(8);
                            a.this.R.setVisibility(8);
                        }
                        z16 = true;
                        a.this.n();
                        ActionSheet actionSheet22 = a.this.L;
                        StringBuilder sb522 = new StringBuilder();
                        sb522.append(l.a(R.string.tfh));
                        a aVar222 = a.this;
                        sb522.append(aVar222.p(aVar222.f42509e, this.f42524e));
                        sb522.append(l.a(R.string.tff));
                        actionSheet22.setMainTitle(sb522.toString());
                        if (z16) {
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        View f42526a;

        /* renamed from: b, reason: collision with root package name */
        AvatarImageView f42527b;

        /* renamed from: c, reason: collision with root package name */
        TextView f42528c;

        d() {
        }
    }

    public a(Activity activity, AlbumCacheData albumCacheData, int i3, String str) {
        this.f42510f = activity;
        this.f42509e = albumCacheData;
        this.f42511h = i3;
        this.F = str;
        q();
        this.f42512i = new ViewOnClickListenerC0323a();
    }

    private void A(int i3, d dVar) {
        try {
            ArrayList<SharingAlbumClientAttr> arrayList = this.C;
            if (arrayList != null && arrayList.size() != 0) {
                if (i3 <= this.C.size() || this.C.size() == 0) {
                    int count = getCount();
                    int confirmedSharingOwnersNumber = this.f42509e.getConfirmedSharingOwnersNumber();
                    if (this.K == -1) {
                        this.K = this.f42509e.albumtype;
                    }
                    switch (this.K) {
                        case 8:
                        case 9:
                        case 11:
                        case 12:
                            if (!this.f42509e.isSharingAlbumCreator() && !this.f42509e.isUnsharingAlbumCreator() && !w()) {
                                y(dVar.f42527b, this.C.get(i3).uin);
                                dVar.f42526a.setOnClickListener(new c(this.C.get(i3), i3));
                                z(dVar, i3);
                                dVar.f42528c.setText(p(this.f42509e, i3));
                                dVar.f42528c.setVisibility(0);
                                return;
                            }
                            if (confirmedSharingOwnersNumber < this.f42509e.getMaxCount() && i3 == count - 1) {
                                x(dVar.f42527b);
                                if (this.f42509e.albumtype == 11) {
                                    dVar.f42526a.setOnClickListener(this.f42512i);
                                } else {
                                    dVar.f42526a.setOnClickListener(new c(null, -1));
                                }
                                dVar.f42528c.setText(l.a(R.string.f170028dd));
                            } else {
                                if (this.C.get(i3).uin != 0) {
                                    y(dVar.f42527b, this.C.get(i3).uin);
                                } else {
                                    x(dVar.f42527b);
                                }
                                dVar.f42526a.setOnClickListener(new c(this.C.get(i3), i3));
                                z(dVar, i3);
                                dVar.f42528c.setText(p(this.f42509e, i3));
                            }
                            dVar.f42528c.setVisibility(0);
                            return;
                        case 10:
                        default:
                            com.qzone.proxy.feedcomponent.b.c("SharingOwnersGridAdapter", "getCount switch to default");
                            return;
                    }
                }
            }
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d("SharingOwnersGridAdapter", "updateViewHolderContent error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p(AlbumCacheData albumCacheData, int i3) {
        String str;
        ArrayList<SharingAlbumClientAttr> arrayList = this.C;
        if (arrayList != null && arrayList.size() > i3) {
            if (this.K == -1) {
                this.K = albumCacheData.albumtype;
            }
            if (!albumCacheData.isSharingAlbumOnServer() && albumCacheData.getSharingOwnersNumber() <= 1) {
                str = this.C.get(i3).qq_nick;
            } else {
                str = this.C.get(i3).uinAttr.nick;
                if (TextUtils.isEmpty(str)) {
                    str = this.C.get(i3).qq_nick;
                }
            }
            return !TextUtils.isEmpty(str) ? str : com.qzone.album.env.common.a.m().x(this.C.get(i3).uin);
        }
        return "";
    }

    private void q() {
        this.M = new ActionMenuItem(201, ActionSheetHelper.getStringById(this.f42510f, R.string.gaq), 201, 0);
        this.N = new ActionMenuItem(202, ActionSheetHelper.getStringById(this.f42510f, R.string.gap), 202, 0, 2);
        this.P = new ActionMenuItem(204, ActionSheetHelper.getStringById(this.f42510f, R.string.gar), 204, 0);
        this.Q = new ActionMenuItem(205, ActionSheetHelper.getStringById(this.f42510f, R.string.gat), 205, 0);
        this.R = new ActionMenuItem(206, ActionSheetHelper.getStringById(this.f42510f, R.string.gas), 206, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        return this.f42511h == 0;
    }

    private boolean w() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_SHOULD_SHARE_PARTNER_SHOW_ADD_ICON, 1) == 1 && LocalMultiProcConfig.getInt4Uin("creditlevel", 0, LoginData.getInstance().getUin()) < 7;
    }

    private void z(d dVar, int i3) {
        if (this.f42509e.isSharingAlbumOnServer() || this.f42509e.isSharingAlbumOnUI()) {
            if (this.C.get(i3).uin == this.f42509e.createSharingUin) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("SharingOwnersGridAdapter", 2, "updateStatusIcon creator albumCacheData.createSharingUin:", Long.valueOf(this.f42509e.createSharingUin));
                }
                dVar.f42527b.setForeground(R.drawable.fuo);
                return;
            }
            dVar.f42527b.setForeground((Drawable) null);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<SharingAlbumClientAttr> arrayList;
        if (this.f42509e == null || (arrayList = this.C) == null) {
            return 0;
        }
        int size = arrayList.size();
        if (r()) {
            if (this.f42509e.getSharingOwnersNumber() >= this.f42509e.getMaxCount()) {
                return size;
            }
        } else if ((!this.f42509e.isUnsharingAlbumCreator() && !this.f42509e.isSharingAlbumCreator() && !w()) || this.f42509e.getConfirmedSharingOwnersNumber() >= this.f42509e.getMaxCount()) {
            return size;
        }
        return size + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    public void n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.M);
        arrayList.add(this.N);
        arrayList.add(this.P);
        arrayList.add(this.Q);
        if (e.f44330a) {
            arrayList.add(this.R);
        }
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(this.f42510f, arrayList, this.S);
        this.L = createActionSheet;
        createActionSheet.addCancelButton(R.string.cancel);
    }

    public ArrayList<SharingAlbumClientAttr> o() {
        return this.f42513m;
    }

    public void s(AlbumCacheData albumCacheData) {
        this.f42509e = albumCacheData;
        this.C = new ArrayList<>();
        for (int i3 = 0; i3 < albumCacheData.sharingAlbumClientAttrArrayList.size(); i3++) {
            if (albumCacheData.sharingAlbumClientAttrArrayList.get(i3).uin != 0 && (albumCacheData.sharingAlbumClientAttrArrayList.get(i3).uinAttr.status == 2 || albumCacheData.sharingAlbumClientAttrArrayList.get(i3).uinAttr.status == 0)) {
                this.C.add(albumCacheData.sharingAlbumClientAttrArrayList.get(i3));
            }
        }
    }

    public void t(int i3) {
        this.K = i3;
    }

    public void v(View.OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements ActionSheet.OnButtonClickListener {

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.editalbum.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class DialogInterfaceOnClickListenerC0324a implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SharingAlbumClientAttr f42516d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f42517e;

            DialogInterfaceOnClickListenerC0324a(SharingAlbumClientAttr sharingAlbumClientAttr, int i3) {
                this.f42516d = sharingAlbumClientAttr;
                this.f42517e = i3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (dialogInterface instanceof AlbumDialog) {
                    AlbumDialog albumDialog = (AlbumDialog) dialogInterface;
                    String N = albumDialog.N();
                    if (!TextUtils.isEmpty(N)) {
                        this.f42516d.uinAttr.nick = N;
                        a.this.f42509e.sharingAlbumClientAttrArrayList.get(this.f42517e).action |= 16;
                        a.this.notifyDataSetChanged();
                    }
                    albumDialog.O(a.this.f42510f);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.editalbum.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class DialogInterfaceOnClickListenerC0325b implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0325b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ((AlbumDialog) dialogInterface).O(a.this.f42510f);
                dialogInterface.dismiss();
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class c implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f42520d;

            c(int i3) {
                this.f42520d = i3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (a.this.C == null || a.this.C.size() <= this.f42520d) {
                    return;
                }
                SharingAlbumClientAttr sharingAlbumClientAttr = (SharingAlbumClientAttr) a.this.C.get(this.f42520d);
                if (!a.this.r()) {
                    sharingAlbumClientAttr.action = 8;
                    a.this.f42513m.add(sharingAlbumClientAttr);
                }
                int i16 = 0;
                while (true) {
                    if (i16 >= a.this.f42509e.sharingAlbumClientAttrArrayList.size()) {
                        break;
                    }
                    if (a.this.f42509e.sharingAlbumClientAttrArrayList.get(i16).uin == sharingAlbumClientAttr.uin) {
                        a.this.f42509e.sharingAlbumClientAttrArrayList.remove(i16);
                        a.this.C.remove(this.f42520d);
                        break;
                    }
                    i16++;
                }
                a.this.notifyDataSetChanged();
            }
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class d implements DialogInterface.OnClickListener {
            d() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ((AlbumDialog) dialogInterface).O(a.this.f42510f);
                dialogInterface.dismiss();
            }
        }

        b() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ActionMenuItem actionMenuItem = a.this.L.getActionMenuItem(i3);
            int i16 = actionMenuItem.action;
            SharingAlbumClientAttr sharingAlbumClientAttr = (SharingAlbumClientAttr) actionMenuItem.getTag("clientAttr");
            int intValue = ((Integer) actionMenuItem.getTag("position")).intValue();
            switch (i16) {
                case 201:
                    AlbumDialog albumDialog = new AlbumDialog(a.this.f42510f, R.style.qZoneInputDialog);
                    albumDialog.setContentView(R.layout.bhq);
                    albumDialog.X(1);
                    albumDialog.P(sharingAlbumClientAttr.uin);
                    if (a.this.f42509e.albumtype != 9 && a.this.f42509e.albumtype != 11) {
                        albumDialog.U(sharingAlbumClientAttr.uinAttr.nick);
                    } else {
                        albumDialog.U(sharingAlbumClientAttr.qq_nick);
                    }
                    albumDialog.setTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleShowFollowName", "\u5728\u76f8\u518c\u4e2d\u663e\u793a\u4e3a\u4ee5\u4e0b\u540d\u5b57"));
                    albumDialog.a0(l.a(R.string.ket), new DialogInterfaceOnClickListenerC0324a(sharingAlbumClientAttr, intValue));
                    albumDialog.Y(l.a(R.string.j6l), new DialogInterfaceOnClickListenerC0325b());
                    albumDialog.show();
                    albumDialog.d0(a.this.f42510f);
                    com.qzone.album.env.common.a.m().P(402, 5, "3", true, a.this.f42509e.albumid);
                    break;
                case 202:
                    if (!q.a("keyDeleteSharePerson")) {
                        if (a.this.C != null && a.this.C.size() > intValue) {
                            SharingAlbumClientAttr sharingAlbumClientAttr2 = (SharingAlbumClientAttr) a.this.C.get(intValue);
                            if (!a.this.r()) {
                                sharingAlbumClientAttr2.action = 8;
                                a.this.f42513m.add(sharingAlbumClientAttr2);
                            }
                            int i17 = 0;
                            while (true) {
                                if (i17 < a.this.f42509e.sharingAlbumClientAttrArrayList.size()) {
                                    if (a.this.f42509e.sharingAlbumClientAttrArrayList.get(i17).uin == sharingAlbumClientAttr2.uin) {
                                        a.this.f42509e.sharingAlbumClientAttrArrayList.remove(i17);
                                        a.this.C.remove(intValue);
                                    } else {
                                        i17++;
                                    }
                                }
                            }
                            a.this.notifyDataSetChanged();
                        }
                    } else {
                        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleDeleteSharedPeople", "\u5220\u9664\u5171\u4eab\u4eba");
                        String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageDeleteSharedPeople", "\u5c06\u5171\u4eab\u4eba\u5220\u9664\u540e\uff0c\u4ed6\u5c06\u65e0\u6cd5\u518d\u67e5\u770b\u3001\u4e0a\u4f20\u7167\u7247\u5230\u672c\u76f8\u518c");
                        AlbumDialog albumDialog2 = new AlbumDialog(a.this.f42510f, R.style.qZoneInputDialog);
                        albumDialog2.setContentView(R.layout.bhq);
                        albumDialog2.X(2);
                        albumDialog2.setTitle(config);
                        albumDialog2.Q(config2);
                        albumDialog2.a0(l.a(R.string.ket), new c(intValue));
                        albumDialog2.Y(l.a(R.string.j6l), new d());
                        albumDialog2.show();
                    }
                    if (a.this.f42509e.albumtype == 8) {
                        com.qzone.album.env.common.a.m().P(402, 5, "4", true, a.this.f42509e.albumid);
                        break;
                    } else if (a.this.f42509e.albumtype == 9) {
                        com.qzone.album.env.common.a.m().P(402, 5, "5", true, a.this.f42509e.albumid);
                        break;
                    } else if (a.this.f42509e.albumtype == 11) {
                        com.qzone.album.env.common.a.m().P(402, 5, "7", true, a.this.f42509e.albumid);
                        break;
                    } else if (a.this.f42509e.albumtype == 12) {
                        com.qzone.album.env.common.a.m().P(402, 5, "8", true, a.this.f42509e.albumid);
                        break;
                    }
                    break;
                case 204:
                    if (a.this.f42509e != null) {
                        if (a.this.f42509e.albumtype == 11) {
                            com.qzone.album.env.common.a.m().z(a.this.f42510f, -1, 14);
                            com.qzone.album.env.common.a.m().P(402, 5, "6", true, a.this.f42509e.albumid);
                        } else {
                            int maxCount = a.this.f42509e.getMaxCount() - a.this.f42509e.getConfirmedSharingOwnersNumber();
                            if (maxCount <= 0) {
                                com.qzone.album.env.common.a.m().W(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ReachMaxLimit", "\u76f8\u518c\u5171\u4eab\u4eba\u5df2\u8fbe\u4e0a\u9650"), 4);
                            } else {
                                com.qzone.album.env.common.a.m().y(a.this.f42510f, 1, maxCount, -1, 12, a.this.f42509e.getConfirmedSharingOwnersList(), false);
                            }
                        }
                        if (a.this.f42509e.albumtype == 9) {
                            com.qzone.album.env.common.a.m().P(402, 4, "3", true, a.this.f42509e.albumid);
                            break;
                        } else if (a.this.f42509e.albumtype == 8) {
                            com.qzone.album.env.common.a.m().P(402, 4, "2", true, a.this.f42509e.albumid);
                            break;
                        } else if (a.this.f42509e.albumtype == 12) {
                            if (a.this.f42509e.sharingAlbumClientAttrArrayList != null && a.this.f42509e.sharingAlbumClientAttrArrayList.size() > 1) {
                                com.qzone.album.env.common.a.m().P(402, 4, "7", true, a.this.f42509e.albumid);
                                break;
                            } else {
                                com.qzone.album.env.common.a.m().P(402, 4, "6", true, a.this.f42509e.albumid);
                                break;
                            }
                        }
                    } else {
                        return;
                    }
                    break;
                case 205:
                    if (a.this.f42509e != null && a.this.I != null && a.this.G != null && a.this.H != null) {
                        ShareUtils.e eVar = new ShareUtils.e();
                        eVar.f44740a = a.this.I;
                        eVar.f44711h = 2;
                        eVar.f44743d = a.this.G;
                        eVar.f44712i = QZoneShareManager.QQ_SHARE_APPID;
                        eVar.f44713j = 1;
                        eVar.f44741b = a.this.H;
                        eVar.f44715l = true;
                        eVar.d(a.this.f42509e.ark_content_invate, a.this.f42509e.ark_id_invate, a.this.f42509e.view_id_invate, a.this.G, a.this.H, a.this.I);
                        ShareUtils.n(a.this.f42510f, eVar, 0);
                        if (a.this.f42509e.albumtype == 12) {
                            com.qzone.album.env.common.a.m().P(326, 14, "10", true, null);
                            break;
                        }
                    }
                    break;
                case 206:
                    if (a.this.D != null) {
                        a.this.D.onClick(view);
                    }
                    QZoneAlbumUtil.y(a.this.f42510f, a.this.f42509e);
                    break;
            }
            ActionSheetHelper.dismissActionSheet(a.this.f42510f, a.this.L);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        if (view != null && view.getTag() != null) {
            dVar = (d) view.getTag();
        } else {
            view = LayoutInflater.from(this.f42510f).inflate(R.layout.bif, (ViewGroup) null);
            dVar = new d();
            dVar.f42526a = view;
            AvatarImageView avatarImageView = (AvatarImageView) view.findViewById(R.id.hc9);
            dVar.f42527b = avatarImageView;
            avatarImageView.setDefaultAvatar(R.drawable.aql);
            dVar.f42527b.setForeground((Drawable) null);
            dVar.f42527b.setFocusable(false);
            dVar.f42528c = (TextView) view.findViewById(R.id.hc_);
            view.setTag(dVar);
        }
        A(i3, dVar);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void u(PublicShareCacheData publicShareCacheData) {
        if (publicShareCacheData != null) {
            this.G = publicShareCacheData.cover;
            this.H = publicShareCacheData.desc;
            this.I = publicShareCacheData.h5url;
            this.J = publicShareCacheData.schema;
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.editalbum.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class ViewOnClickListenerC0323a implements View.OnClickListener {
        ViewOnClickListenerC0323a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.f42509e != null) {
                if (a.this.f42509e.albumtype == 11) {
                    com.qzone.album.env.common.a.m().z(a.this.f42510f, -1, 14);
                    com.qzone.album.env.common.a.m().P(402, 5, "6", true, a.this.f42509e.albumid);
                } else {
                    com.qzone.album.env.common.a.m().y(a.this.f42510f, 1, a.this.f42509e.getMaxCount() - a.this.f42509e.getConfirmedSharingOwnersNumber(), -1, 12, a.this.f42509e.getConfirmedSharingOwnersList(), false);
                }
                if (a.this.f42509e.albumtype == 9) {
                    com.qzone.album.env.common.a.m().P(402, 4, "3", true, a.this.f42509e.albumid);
                } else if (a.this.f42509e.albumtype == 8) {
                    com.qzone.album.env.common.a.m().P(402, 4, "2", true, a.this.f42509e.albumid);
                } else if (a.this.f42509e.albumtype == 12) {
                    if (a.this.f42509e.sharingAlbumClientAttrArrayList != null && a.this.f42509e.sharingAlbumClientAttrArrayList.size() > 1) {
                        com.qzone.album.env.common.a.m().P(402, 4, "7", true, a.this.f42509e.albumid);
                    } else {
                        com.qzone.album.env.common.a.m().P(402, 4, "6", true, a.this.f42509e.albumid);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void x(AvatarImageView avatarImageView) {
        avatarImageView.setDefaultAvatar(R.drawable.fvn);
        avatarImageView.loadAvatar(0L);
        avatarImageView.setForeground((Drawable) null);
    }

    private void y(AvatarImageView avatarImageView, long j3) {
        avatarImageView.setDefaultAvatar(R.drawable.f160830com);
        avatarImageView.loadAvatar(j3);
    }
}
