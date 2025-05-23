package mn;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends a implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    private QZoneUserAvatarView f417013e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f417014f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f417015h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f417016i;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void A(gn.e eVar) {
        eVar.F0(new bn.d((bn.b) this.mData, this.mPosition));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(String str) {
        QLog.e("QZMFeedTitlePresenter", 1, "handleOnClickUserAvatar getIoc error = " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D() {
        this.f417014f.setText(((bn.b) this.mData).a().poster.nick.get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F() {
        String b16 = rn.a.b(((bn.b) this.mData).a().createTime.get() * 1000);
        if (!TextUtils.isEmpty(((bn.b) this.mData).a().poiInfo.name.get())) {
            b16 = b16 + APLogFileUtil.SEPARATOR_LOG + ((bn.b) this.mData).a().poiInfo.name.get();
        }
        this.f417015h.setText(b16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G() {
        long j3;
        try {
            j3 = Long.parseLong(((bn.b) this.mData).a().poster.f430367id.get());
        } catch (NumberFormatException e16) {
            QLog.e("QZMFeedTitlePresenter", 1, "updateUserAvatar  e = " + e16.getMessage());
            j3 = 0;
        }
        QLog.d("QZMFeedTitlePresenter", 1, "updateUserAvatar   | uin = " + j3 + " | nick = " + ((bn.b) this.mData).a().poster.nick.get() + " | feedId = " + ((bn.b) this.mData).a().f430362id.get() + " | pos = " + this.mPosition + " | hashCode = " + hashCode());
        this.f417013e.setUser(j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x() {
        HashMap hashMap = new HashMap();
        hashMap.put("operated_feed", ((bn.b) this.mData).a().f430362id.get());
        hashMap.put("author_id", ((bn.b) this.mData).a().poster.f430367id.get());
        fo.c.o(this.f417016i, "em_bas_menu", new fo.b().l(hashMap).i(((bn.b) this.mData).a().f430362id.get()));
    }

    private void y() {
        RFWIocAbilityProvider.g().getIoc(gn.e.class).originView(this.mRootView).done(new OnPromiseResolved() { // from class: mn.e
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                g.this.A((gn.e) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: mn.f
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                g.B(str);
            }
        }).run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        int i3;
        try {
            i3 = Integer.parseInt(((bn.b) this.mData).a().poster.f430367id.get());
        } catch (Exception e16) {
            QLog.e("QZMFeedTitlePresenter", 1, "handleOnClickUserAvatar e = " + e16.getMessage());
            i3 = 0;
        }
        ho.h.b(p(), i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mn.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedTitlePresenter";
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r0 != com.tencent.mobileqq.R.id.mlp) goto L11;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.f162778ml1) {
            if (id5 == R.id.mll) {
                y();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
        z();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mki};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.b bVar, int i3, List<Object> list) {
        if (bVar == null) {
            return;
        }
        G();
        D();
        F();
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f417013e = (QZoneUserAvatarView) view.findViewById(R.id.mlp);
        this.f417014f = (TextView) view.findViewById(R.id.f162778ml1);
        this.f417015h = (TextView) view.findViewById(R.id.mlf);
        ImageView imageView = (ImageView) view.findViewById(R.id.mll);
        this.f417016i = imageView;
        rn.h.a(imageView, "qui_more", R.color.qui_common_icon_secondary);
        this.f417013e.setOnClickListener(this);
        this.f417014f.setOnClickListener(this);
        this.f417016i.setOnClickListener(this);
    }
}
