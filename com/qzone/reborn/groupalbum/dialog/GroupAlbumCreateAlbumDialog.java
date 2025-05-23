package com.qzone.reborn.groupalbum.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import ba.d;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumCreateAlbumInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumEditAlbumEvent;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceAddAlbumCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import fj.r;
import fo.b;
import fo.c;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class GroupAlbumCreateAlbumDialog extends d implements View.OnClickListener, View.OnTouchListener {
    private EditText L;
    private ImageView M;
    private d.C0114d N;
    private EditText P;
    private d.C0114d Q;
    private a R;
    private GroupAlbumCreateAlbumInitBean S;
    private boolean T;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(boolean z16, AlbumInfo albumInfo);
    }

    public GroupAlbumCreateAlbumDialog(Context context, GroupAlbumCreateAlbumInitBean groupAlbumCreateAlbumInitBean) {
        super(context);
        this.T = false;
        this.S = groupAlbumCreateAlbumInitBean;
    }

    private void k0() {
        EditText editText;
        QUIButton qUIButton = this.F;
        if (qUIButton == null || (editText = this.L) == null) {
            return;
        }
        qUIButton.setEnabled(!TextUtils.isEmpty(editText.getText().toString().trim()));
    }

    private void l0() {
        View view = this.C;
        b bVar = new b();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        c.o(view, "em_qz_create_a_album", bVar.g(clickPolicy));
        c.o(this.L, "em_qz_add_album_name", new b().g(clickPolicy));
        c.o(this.P, "em_qz_add_album_description", new b().g(clickPolicy));
        c.o(this.F, "em_qz_create_album_button", null);
    }

    private AlbumInfo m0(String str, String str2, long j3, String str3) {
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.owner = str3;
        albumInfo.name = str;
        albumInfo.desc = str2;
        albumInfo.createTime = j3;
        return albumInfo;
    }

    private void n0() {
        String groupId;
        String trim = this.L.getText().toString().trim();
        String trim2 = this.P.getText().toString().trim();
        long currentTimeMillis = System.currentTimeMillis();
        GroupAlbumCreateAlbumInitBean groupAlbumCreateAlbumInitBean = this.S;
        if (groupAlbumCreateAlbumInitBean == null) {
            groupId = "";
        } else {
            groupId = groupAlbumCreateAlbumInitBean.getGroupId();
        }
        String str = groupId;
        QLog.d("GroupAlbumCreateAlbumDialog", 1, "[handleCreateBtnClick] groupId = " + str + ", albumName = " + trim + ", albumDesc = " + trim2 + ", createTime = " + currentTimeMillis);
        d0(getContext().getResources().getString(R.string.ghr));
        final AlbumInfo m06 = m0(trim, trim2, currentTimeMillis, str);
        r.b().v0(m06, new IAlbumServiceAddAlbumCallback() { // from class: com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog.1
            /* JADX INFO: Access modifiers changed from: private */
            public void b(int i3) {
                HashMap hashMap = new HashMap();
                hashMap.put("add_album_success", Integer.valueOf(i3 == 0 ? 1 : 0));
                c.c("ev_qun_album_on_add_album", hashMap);
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceAddAlbumCallback
            public void onAddAlbum(int i3, final int i16, final String str2, final AlbumInfo albumInfo) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumInfo albumInfo2;
                        String groupId2;
                        GroupAlbumCreateAlbumDialog.this.P();
                        boolean z16 = i16 == 0;
                        QLog.d("GroupAlbumCreateAlbumDialog", 1, "[addAlbumRsp] isSuccess: " + z16 + ", retCode: " + i16 + ", errMsg: " + str2);
                        if (GroupAlbumCreateAlbumDialog.this.R != null) {
                            if (!z16 || (albumInfo2 = albumInfo) == null) {
                                albumInfo2 = m06;
                            }
                            GroupAlbumCreateAlbumDialog.this.R.a(z16, albumInfo2);
                            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                            if (GroupAlbumCreateAlbumDialog.this.S == null) {
                                groupId2 = "";
                            } else {
                                groupId2 = GroupAlbumCreateAlbumDialog.this.S.getGroupId();
                            }
                            simpleEventBus.dispatchEvent(new GroupAlbumEditAlbumEvent(groupId2, null, null, xh.a.a(albumInfo2)));
                        }
                        b(i16);
                        if (!z16 && !TextUtils.isEmpty(str2)) {
                            QQToast.makeText(GroupAlbumCreateAlbumDialog.this.getContext(), 1, str2, 0).show();
                        }
                        GroupAlbumCreateAlbumDialog.this.dismiss();
                    }
                });
            }
        });
    }

    private void o0() {
        EditText editText = this.L;
        if (editText == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(Editable editable) {
        k0();
    }

    private void q0() {
        String pageId;
        String groupId;
        GroupAlbumCreateAlbumInitBean groupAlbumCreateAlbumInitBean = this.S;
        if (groupAlbumCreateAlbumInitBean == null) {
            pageId = "qzone_base_pageId";
        } else {
            pageId = groupAlbumCreateAlbumInitBean.getPageId();
        }
        VideoReport.setPageId(this.C, pageId);
        VideoReport.setPageReportPolicy(this.C, PageReportPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        GroupAlbumCreateAlbumInitBean groupAlbumCreateAlbumInitBean2 = this.S;
        Object obj = "";
        if (groupAlbumCreateAlbumInitBean2 == null) {
            groupId = "";
        } else {
            groupId = groupAlbumCreateAlbumInitBean2.getGroupId();
        }
        hashMap.put("close_friend_space_id", groupId);
        GroupAlbumCreateAlbumInitBean groupAlbumCreateAlbumInitBean3 = this.S;
        if (groupAlbumCreateAlbumInitBean3 != null) {
            obj = Integer.valueOf(groupAlbumCreateAlbumInitBean3.getSpaceType());
        }
        hashMap.put("close_friend_space_type", obj);
        VideoReport.setPageParams(this.C, new QCircleDTParamBuilder().buildPageParams("GroupAlbumCreateAlbumDialog", hashMap));
    }

    @Override // ba.d
    protected int Q() {
        return R.layout.f127761j;
    }

    @Override // ba.d
    protected String R() {
        return "GroupAlbumCreateAlbumDialog";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d
    public void Z(View view) {
        n0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d
    public void a0() {
        U(this.L);
        U(this.P);
    }

    @Override // ba.d
    protected void b0() {
        if (this.T) {
            return;
        }
        c0(this.L);
        this.T = true;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.L.removeTextChangedListener(this.N);
        this.P.removeTextChangedListener(this.Q);
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.kls) {
            o0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q0();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (view.getId() == R.id.f20578r) {
            c0(this.L);
            c.b("dt_clck", this.L, "em_qz_add_album_name", null);
            return false;
        }
        if (view.getId() != R.id.f20568q) {
            return false;
        }
        c.b("dt_clck", this.P, "em_qz_add_album_description", null);
        return false;
    }

    public void r0(a aVar) {
        this.R = aVar;
    }

    @Override // ba.d
    protected void W(View view) {
        EditText editText = (EditText) view.findViewById(R.id.f20578r);
        this.L = editText;
        editText.setOnTouchListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.kls);
        this.M = imageView;
        imageView.setOnClickListener(this);
        d.C0114d c0114d = new d.C0114d(this.L, 15, getContext().getResources().getString(R.string.ghv));
        this.N = c0114d;
        c0114d.a(new d.e() { // from class: com.qzone.reborn.groupalbum.dialog.a
            @Override // ba.d.e
            public final void afterTextChanged(Editable editable) {
                GroupAlbumCreateAlbumDialog.this.p0(editable);
            }
        });
        this.L.addTextChangedListener(this.N);
        EditText editText2 = (EditText) view.findViewById(R.id.f20568q);
        this.P = editText2;
        editText2.setOnTouchListener(this);
        d.C0114d c0114d2 = new d.C0114d(this.P, 50, getContext().getResources().getString(R.string.ghq));
        this.Q = c0114d2;
        this.P.addTextChangedListener(c0114d2);
        l0();
    }
}
