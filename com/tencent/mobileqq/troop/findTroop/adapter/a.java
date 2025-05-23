package com.tencent.mobileqq.troop.findTroop.adapter;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends RecommendTroopAdapter {
    static IPatchRedirector $redirector_;
    String E;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.findTroop.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8695a implements IAddAcceptBlockStrategy.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecommendTroopItem f296029a;

        C8695a(RecommendTroopItem recommendTroopItem) {
            this.f296029a = recommendTroopItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) recommendTroopItem);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).joinRecommendTroop(a.this.i(), this.f296029a, a.this.z());
            }
        }
    }

    public a(Context context, AppInterface appInterface, boolean z16, String str) {
        super(context, appInterface, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, Boolean.valueOf(z16), str);
        } else {
            this.E = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
    public Map<String, Object> j(int i3, @NonNull RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) recommendTroopItem);
        }
        Map<String, Object> j3 = super.j(i3, recommendTroopItem);
        if (com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
            int i16 = 0;
            while (true) {
                if (i16 >= recommendTroopItem.labelList.size()) {
                    break;
                }
                if (recommendTroopItem.labelList.get(i16).uint32_label_type.get() == 104) {
                    j3.put("group_special_tag", recommendTroopItem.labelList.get(i16).bytes_name.get().toStringUtf8());
                    break;
                }
                i16++;
            }
            if (!TextUtils.isEmpty(this.E)) {
                j3.put("tab_name", this.E);
            }
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
    protected int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 21;
    }

    @Override // com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
    protected int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 10003;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
    public void q(RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) recommendTroopItem);
        } else {
            super.q(recommendTroopItem);
            ReportController.o(null, "dc00899", "Grp_find_new", "", "grptab", "exp_grp", 0, 0, recommendTroopItem.uin, recommendTroopItem.recomAlgol, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
    public void r(RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) recommendTroopItem);
        } else {
            super.r(recommendTroopItem);
            ReportController.o(null, "dc00899", "Grp_find_new", "", "grptab", "Clk_join", 0, 0, recommendTroopItem.uin, recommendTroopItem.recomAlgol, "", "");
        }
    }

    @Override // com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter
    protected void s(RecommendTroopItem recommendTroopItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recommendTroopItem);
        } else {
            ReportController.o(null, "dc00899", "Grp_recom", "", "search", "recom_clk_add", 0, 0, recommendTroopItem.uin, recommendTroopItem.recomAlgol, "", "");
            ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(g(), 10003, i(), new C8695a(recommendTroopItem));
        }
    }

    protected int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 10028;
    }
}
