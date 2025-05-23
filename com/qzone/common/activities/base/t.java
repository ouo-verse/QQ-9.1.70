package com.qzone.common.activities.base;

import android.content.DialogInterface;
import android.view.View;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.personalize.ArchiveMemorySettingGuide;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
@Named("BaseFeedFragmentQDialogImp")
/* loaded from: classes39.dex */
public class t implements d5.z<BusinessFeedData> {

    /* renamed from: a, reason: collision with root package name */
    private d5.u f45537a;

    /* renamed from: b, reason: collision with root package name */
    private d5.j<BusinessFeedData> f45538b;

    /* renamed from: c, reason: collision with root package name */
    private d5.o<BusinessFeedData> f45539c;

    /* renamed from: d, reason: collision with root package name */
    private ActionSheet.OnButtonClickListener f45540d;

    /* renamed from: e, reason: collision with root package name */
    protected ActionSheet f45541e;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ArchiveMemorySettingGuide.o().w();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ArchiveMemorySettingGuide.o().x();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ArchiveMemorySettingGuide.o().w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements ActionSheet.OnButtonClickListener {
        d() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            BusinessFeedData businessFeedData = (BusinessFeedData) t.this.f45541e.getActionMenuItem(i3).getTag("tag_feedop_data");
            t.this.f45539c.d(new k(businessFeedData), t.this.f45541e.getActionMenuItem(i3).action, ((Integer) t.this.f45541e.getActionMenuItem(i3).getTag("tag_feedop_enter_from")).intValue());
            try {
                ActionSheetHelper.dismissActionSheet(t.this.f45537a.getActivity(), t.this.f45541e);
            } catch (Throwable unused) {
            }
        }
    }

    @Inject
    public t() {
    }

    private void f() {
        if (this.f45540d != null) {
            return;
        }
        this.f45540d = new d();
    }

    @Override // d5.z
    public void a(d5.k<BusinessFeedData> kVar, int i3) {
        BusinessFeedData b16 = kVar.b();
        if (QZoneFeedUtil.i(b16)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f45537a.getActivity(), R.string.gel), 0, QZoneFeedUtil.e(b16) ? 0 : 8));
            if (QZoneFeedUtil.g(b16) && !b16.isSecretFeed()) {
                arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f45537a.getActivity(), R.string.ges), 5, 0));
            } else if (QZoneFeedUtil.h(b16)) {
                arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f45537a.getActivity(), R.string.get), 8, 0));
            }
            if (QZoneFeedUtil.l(b16, 25)) {
                int G = u5.b.G("highFiveNotifyStatus", -1);
                QZLog.i("BaseFeedFragmentQDialog", 1, "High Five passive button, status = " + G);
                if (G == 0) {
                    arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f45537a.getActivity(), R.string.gei), 25, 0));
                } else if (G == 1) {
                    arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f45537a.getActivity(), R.string.geq), 25, 0));
                }
            }
            arrayList.add(new ActionMenuItem(0, ActionSheetHelper.getStringById(this.f45537a.getActivity(), i3 == 1 ? R.string.gfc : R.string.gek), 10, 0, 2));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ActionMenuItem actionMenuItem = (ActionMenuItem) it.next();
                actionMenuItem.setTag("tag_feedop_data", b16);
                actionMenuItem.setTag("tag_feedop_enter_from", Integer.valueOf(i3));
            }
            f();
            com.qzone.widget.o a16 = com.qzone.widget.p.a(this.f45537a.getActivity(), arrayList, this.f45540d);
            this.f45541e = a16;
            a16.addCancelButton(R.string.cancel);
            ActionSheetHelper.showActionSheet(this.f45537a.getActivity(), this.f45541e);
        }
    }

    @Override // d5.z
    public void b(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        new com.qzone.component.e().g(this.f45537a.getActivity(), str, str2, onClickListener, onClickListener2);
    }

    @Override // d5.z
    public void c(CharSequence charSequence) {
        if (this.f45537a.isFinishing() || this.f45537a.isDestroyed()) {
            return;
        }
        QQCustomDialog message = DialogUtil.createCustomDialog(this.f45537a.getActivity(), 230).setPositiveButton(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogGoSetting", "\u53bb\u8bbe\u7f6e"), new b()).setNegativeButton(com.qzone.util.l.a(R.string.j6l), new a()).setMessage(charSequence);
        message.setTitle(R.string.gnz);
        message.setOnCancelListener(new c());
        if (!this.f45537a.isFinishing() && !this.f45537a.isDestroyed()) {
            try {
                message.show();
                ArchiveMemorySettingGuide.o().z();
            } catch (Exception unused) {
            }
        }
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45537a = uVar;
    }

    @Inject
    @Named("BaseFeedFragmentFavorImp")
    public void setFavorInf(d5.j<BusinessFeedData> jVar) {
        this.f45538b = jVar;
    }

    @Inject
    public void setFeedPresenterInf(d5.o<BusinessFeedData> oVar) {
        this.f45539c = oVar;
    }

    @Override // d5.z
    public void j(int i3, String str, String str2, String str3, boolean z16, String str4, String str5, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        d5.u uVar = this.f45537a;
        if (uVar == null || uVar.getActivity() == null || this.f45537a.getActivity().isFinishing()) {
            return;
        }
        DialogUtil.createDialogWithCheckBox(this.f45537a.getActivity(), i3, str, str2, str3, z16, str4, str5, onClickListener, onClickListener2, onClickListener3).show();
    }
}
