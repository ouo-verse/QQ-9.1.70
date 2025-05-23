package com.tencent.mobileqq.wink.publish.part;

import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.wink.event.WinkUpdatePublishDeclarationEvent;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class o extends j implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private PublishViewModel f325910d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f325911e;

    private void F9(View view) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_AUTONOMOUS_DECLARE_BUTTON);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private String G9() {
        try {
            return "mqqapi://qcircle/openwebview?open_type=half&url=" + URLEncoder.encode(H9(), "UTF-8");
        } catch (Exception e16) {
            w53.b.d("PublishDeclarationPart", "[getJumpWebViewSchema]", e16);
            return "";
        }
    }

    private String H9() {
        StringBuilder sb5 = new StringBuilder("https://m.xsj.qq.com/h5/publish-assistant/self-declaration?_wv=2");
        DeclarationParams h26 = this.f325910d.h2();
        if (h26 != null) {
            sb5.append("&declaration_id=");
            sb5.append(h26.getId());
            if (h26.getSourceInfo() != null && !TextUtils.isEmpty(h26.getSourceInfo().feed_id.get()) && !TextUtils.isEmpty(h26.getSourceInfo().ec_uid.get())) {
                sb5.append("&feed_id=");
                sb5.append(h26.getSourceInfo().feed_id.get());
                sb5.append("&ec_uid=");
                sb5.append(h26.getSourceInfo().ec_uid.get());
            }
            if (h26.getShootLbs() != null && !TextUtils.isEmpty(h26.getShootLbs().country.get()) && h26.getShootLbs().shoot_time.get() != 0) {
                sb5.append("&shoot_time=");
                sb5.append(h26.getShootLbs().shoot_time.get());
                sb5.append("&country=");
                sb5.append(h26.getShootLbs().country.get());
                if (!TextUtils.isEmpty(h26.getShootLbs().province.get())) {
                    sb5.append("&province=");
                    sb5.append(h26.getShootLbs().province.get());
                }
                if (!TextUtils.isEmpty(h26.getShootLbs().city.get())) {
                    sb5.append("&city=");
                    sb5.append(h26.getShootLbs().city.get());
                }
            }
        }
        QLog.d("PublishDeclarationPart", 1, "getURL... url:" + ((Object) sb5));
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(List list) {
        if (list == null || list.isEmpty() || this.f325910d.L2()) {
            return;
        }
        L9((ha3.b) list.get(0));
    }

    private void K9() {
        LiveData<List<ha3.b>> liveData = this.f325910d.H;
        if (liveData != null) {
            liveData.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    o.this.I9((List) obj);
                }
            });
        }
    }

    private void L9(ha3.b bVar) {
        HashMap<String, String> hashMap;
        String str;
        PublishViewModel publishViewModel;
        if (bVar != null && bVar.f404636u != null && (publishViewModel = this.f325910d) != null) {
            if (publishViewModel.L0 != null) {
                QLog.d("PublishDeclarationPart", 1, "recoveryDeclaration... has declarationParams:" + this.f325910d.L0);
                return;
            }
            QLog.d("PublishDeclarationPart", 1, "recoveryDeclaration... declarationParams:" + bVar.f404636u);
            PublishViewModel publishViewModel2 = this.f325910d;
            DeclarationParams declarationParams = bVar.f404636u;
            publishViewModel2.L0 = declarationParams;
            if (!declarationParams.getName().isEmpty()) {
                this.f325911e.setText(this.f325910d.L0.getName());
                return;
            } else {
                this.f325911e.setText("");
                return;
            }
        }
        if (bVar != null && (hashMap = bVar.f404635t) != null && this.f325910d != null && (str = hashMap.get("declaration_id")) != null) {
            QLog.d("PublishDeclarationPart", 1, "recoveryDeclaration... old version declarationId:" + str);
            this.f325910d.L0 = new DeclarationParams(str, "", null, null);
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return "PublishDeclarationPart";
    }

    public <T> T E9(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        return createFromParcel;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WinkUpdatePublishDeclarationEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f31930sd) {
            if (PadUtil.a(RFWApplication.getApplication()) == DeviceType.FOLD) {
                com.tencent.mobileqq.wink.f.l(getContext(), G9());
            } else {
                com.tencent.mobileqq.wink.f.l(getContext(), com.tencent.mobileqq.webview.util.f.f314875a.b(0.6f, H9()));
            }
        } else if (view.getId() == R.id.f165922y24) {
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u81ea\u4e3b\u58f0\u660e\u4e3a\u4f5c\u54c1\u8865\u5145\u8bf4\u660e\uff0c\u975e\u514d\u8d23\u58f0\u660e", (String) null, "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }, (DialogInterface.OnClickListener) null).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f325911e = (TextView) view.findViewById(R.id.f164957uf3);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f31930sd);
        relativeLayout.setOnClickListener(this);
        F9(relativeLayout);
        ((ImageView) view.findViewById(R.id.f165922y24)).setOnClickListener(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        if (this.f325910d == null) {
            this.f325910d = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        K9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof WinkUpdatePublishDeclarationEvent) {
            byte[] byteArray = ((WinkUpdatePublishDeclarationEvent) simpleBaseEvent).getByteArray();
            this.f325910d.L0 = (DeclarationParams) E9(byteArray, DeclarationParams.CREATOR);
            if (!this.f325910d.L0.getName().isEmpty()) {
                this.f325911e.setText(this.f325910d.L0.getName());
            } else {
                this.f325911e.setText("");
            }
        }
    }
}
