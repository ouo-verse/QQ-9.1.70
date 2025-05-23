package nj;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import ba.d;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateCreateAlbumDialogInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateEditAlbumEvent;
import com.qzone.reborn.intimate.request.QZoneIntimateAddAlbumRequest;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.HashMap;
import qzone.QZIntimateSpaceAlbum$AddAlbumRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends ba.d implements View.OnClickListener, View.OnTouchListener {
    private EditText L;
    private ImageView M;
    private d.C0114d N;
    private EditText P;
    private d.C0114d Q;
    private InterfaceC10848b R;
    private QZoneIntimateCreateAlbumDialogInitBean S;
    private boolean T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceAlbum$AddAlbumRsp> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QZIntimateSpaceAlbum$AddAlbumRsp qZIntimateSpaceAlbum$AddAlbumRsp) {
            QZoneBaseAlbumMeta$AlbumInfo albumInfo;
            String spaceId;
            b.this.P();
            QLog.d("QZoneIntimateCreateAlbumDialog", 1, "[addAlbumRsp] isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str + ", traceId: " + baseRequest.getTraceId());
            if (b.this.R != null) {
                if (z16 && qZIntimateSpaceAlbum$AddAlbumRsp != null) {
                    albumInfo = qZIntimateSpaceAlbum$AddAlbumRsp.album_info.get();
                } else {
                    albumInfo = ((QZoneIntimateAddAlbumRequest) baseRequest).getAlbumInfo();
                }
                b.this.R.a(z16, albumInfo);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                if (b.this.S == null) {
                    spaceId = "";
                } else {
                    spaceId = b.this.S.getSpaceId();
                }
                simpleEventBus.dispatchEvent(new QZoneIntimateEditAlbumEvent(spaceId, null, null, albumInfo));
            }
            if (!z16 && !TextUtils.isEmpty(str)) {
                QQToast.makeText(b.this.getContext(), 1, str, 0).show();
            }
            b.this.dismiss();
        }
    }

    /* compiled from: P */
    /* renamed from: nj.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10848b {
        void a(boolean z16, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo);
    }

    public b(Context context) {
        super(context);
        this.T = false;
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
        fo.b bVar = new fo.b();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        fo.c.o(view, "em_qz_create_a_album", bVar.g(clickPolicy));
        fo.c.o(this.L, "em_qz_add_album_name", new fo.b().g(clickPolicy));
        fo.c.o(this.P, "em_qz_add_album_description", new fo.b().g(clickPolicy));
        fo.c.o(this.F, "em_qz_create_album_button", null);
    }

    private void m0() {
        String spaceId;
        String trim = this.L.getText().toString().trim();
        String trim2 = this.P.getText().toString().trim();
        long currentTimeMillis = System.currentTimeMillis();
        QZoneIntimateCreateAlbumDialogInitBean qZoneIntimateCreateAlbumDialogInitBean = this.S;
        if (qZoneIntimateCreateAlbumDialogInitBean == null) {
            spaceId = "";
        } else {
            spaceId = qZoneIntimateCreateAlbumDialogInitBean.getSpaceId();
        }
        String str = spaceId;
        QLog.d("QZoneIntimateCreateAlbumDialog", 1, "[handleCreateBtnClick] spaceId = " + str + ", albumName = " + trim + ", albumDesc = " + trim2 + ", createTime = " + currentTimeMillis);
        d0(getContext().getResources().getString(R.string.ghr));
        VSNetworkHelper.getInstance().sendRequest(new QZoneIntimateAddAlbumRequest(str, trim, trim2, currentTimeMillis), new a());
    }

    private void n0() {
        EditText editText = this.L;
        if (editText == null) {
            return;
        }
        editText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(Editable editable) {
        k0();
    }

    private void p0() {
        String pageId;
        String spaceId;
        QZoneIntimateCreateAlbumDialogInitBean qZoneIntimateCreateAlbumDialogInitBean = this.S;
        if (qZoneIntimateCreateAlbumDialogInitBean == null) {
            pageId = "qzone_base_pageId";
        } else {
            pageId = qZoneIntimateCreateAlbumDialogInitBean.getPageId();
        }
        VideoReport.setPageId(this.C, pageId);
        VideoReport.setPageReportPolicy(this.C, PageReportPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        QZoneIntimateCreateAlbumDialogInitBean qZoneIntimateCreateAlbumDialogInitBean2 = this.S;
        Object obj = "";
        if (qZoneIntimateCreateAlbumDialogInitBean2 == null) {
            spaceId = "";
        } else {
            spaceId = qZoneIntimateCreateAlbumDialogInitBean2.getSpaceId();
        }
        hashMap.put("close_friend_space_id", spaceId);
        QZoneIntimateCreateAlbumDialogInitBean qZoneIntimateCreateAlbumDialogInitBean3 = this.S;
        if (qZoneIntimateCreateAlbumDialogInitBean3 != null) {
            obj = Integer.valueOf(qZoneIntimateCreateAlbumDialogInitBean3.getSpaceType());
        }
        hashMap.put("close_friend_space_type", obj);
        VideoReport.setPageParams(this.C, new QCircleDTParamBuilder().buildPageParams("QZoneIntimateCreateAlbumDialog", hashMap));
    }

    @Override // ba.d
    protected int Q() {
        return R.layout.cje;
    }

    @Override // ba.d
    protected String R() {
        return "QZoneIntimateCreateAlbumDialog";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d
    public void Z(View view) {
        m0();
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
            n0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ba.d, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p0();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (view.getId() == R.id.f20578r) {
            c0(this.L);
            fo.c.b("dt_clck", this.L, "em_qz_add_album_name", null);
            return false;
        }
        if (view.getId() != R.id.f20568q) {
            return false;
        }
        fo.c.b("dt_clck", this.P, "em_qz_add_album_description", null);
        return false;
    }

    public void q0(InterfaceC10848b interfaceC10848b) {
        this.R = interfaceC10848b;
    }

    public b(Context context, QZoneIntimateCreateAlbumDialogInitBean qZoneIntimateCreateAlbumDialogInitBean) {
        super(context);
        this.T = false;
        this.S = qZoneIntimateCreateAlbumDialogInitBean;
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
        c0114d.a(new d.e() { // from class: nj.a
            @Override // ba.d.e
            public final void afterTextChanged(Editable editable) {
                b.this.o0(editable);
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
