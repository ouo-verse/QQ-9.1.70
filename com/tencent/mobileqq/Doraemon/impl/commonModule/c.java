package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends com.tencent.mobileqq.Doraemon.e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected ShareActionSheet f154162b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements ShareActionSheet.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f154163d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154164e;

        a(int i3, com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154163d = i3;
            this.f154164e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Integer.valueOf(i3), aVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionSheetItem, (Object) shareActionSheet);
                return;
            }
            if (actionSheetItem == null) {
                return;
            }
            c.this.f154162b.dismiss();
            int i17 = actionSheetItem.action;
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 9) {
                            if (i17 != 10) {
                                i3 = -1;
                            } else {
                                i3 = 3;
                            }
                        } else {
                            i3 = 2;
                        }
                    } else {
                        i3 = 1;
                    }
                } else {
                    i3 = 0;
                }
            } else {
                i3 = 4;
            }
            if (i3 == 2 || i3 == 3) {
                if (!WXShareHelper.b0().e0()) {
                    i16 = R.string.f173257ih1;
                } else if (!WXShareHelper.b0().f0()) {
                    i16 = R.string.f173258ih2;
                } else {
                    i16 = -1;
                }
                if (i16 != -1) {
                    BaseApplication context = BaseApplication.getContext();
                    QQToast.makeText(context, context.getString(i16), 0).show(this.f154163d);
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("selectChanel", i3);
                DoraemonUtil.e(this.f154164e, jSONObject);
            } catch (Exception e16) {
                String message = e16.getMessage();
                QLog.e("DoraemonApi.ShareModule", 1, "put channel failed!");
                com.tencent.mobileqq.Doraemon.a aVar = this.f154164e;
                if (message == null) {
                    message = "";
                }
                DoraemonUtil.c(aVar, -1, message);
            }
            if (QLog.isColorLevel()) {
                QLog.i("DoraemonApi.ShareModule", 2, "onItemClick.chooseChannel: " + i17);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f154162b = null;
        }
    }

    public static List<ShareActionSheetBuilder.ActionSheetItem>[] e(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return new ArrayList[]{arrayList, new ArrayList()};
    }

    private void f(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        int optInt = jSONObject.optInt("shareChanel", 0);
        Activity j3 = this.f154095a.j();
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            DoraemonUtil.c(aVar, -1, "net work not available");
            return;
        }
        Intent intent = new Intent(j3, (Class<?>) TroopCreateLogicActivity.class);
        intent.putExtra("type", 8);
        intent.putExtra("chanelId", optInt);
        intent.putExtra("params", jSONObject.toString());
        j3.startActivity(intent);
        DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.f154094a);
    }

    private void g(JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        int i3;
        Activity j3 = this.f154095a.j();
        if (j3 instanceof BaseActivity) {
            i3 = ((BaseActivity) j3).getTitleBarHeight();
        } else {
            i3 = 0;
        }
        a aVar2 = new a(i3, aVar);
        if (this.f154162b == null) {
            ShareActionSheet create = ShareActionSheetFactory.create(j3, false);
            this.f154162b = create;
            create.setActionSheetTitle(j3.getString(R.string.hja));
            this.f154162b.setActionSheetItems(e(j3));
        }
        this.f154162b.setItemClickListenerV2(aVar2);
        try {
            this.f154162b.show();
        } catch (Exception e16) {
            QLog.e("DoraemonApi.ShareModule", 2, "actionSheet.show failed!", e16);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        if (i3 != 27) {
            if (i3 != 30) {
                return false;
            }
            g(jSONObject, aVar);
        } else {
            f(jSONObject, aVar);
        }
        return true;
    }
}
