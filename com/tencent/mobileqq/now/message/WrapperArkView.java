package com.tencent.mobileqq.now.message;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.now.message.WrapperArkView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.data.a;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WrapperArkView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private ArkAppContainer f254345d;

    /* renamed from: e, reason: collision with root package name */
    private ArkAppView f254346e;

    /* renamed from: f, reason: collision with root package name */
    private MsgRecord f254347f;

    public WrapperArkView(Context context, MsgRecord msgRecord) {
        super(context, null);
        this.f254347f = msgRecord;
        this.f254346e = new ArkAppView(context, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f254346e, layoutParams);
        c();
        this.f254346e.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: xb2.h
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                WrapperArkView.d(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    public void b() {
        ArkAppContainer arkAppContainer = this.f254345d;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(2);
        }
    }

    public void c() {
        ArkElement arkElement;
        ArkAppContainer arkAppContainer = this.f254345d;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(2);
        }
        ArrayList<MsgElement> elements = this.f254347f.getElements();
        if (elements == null || elements.size() <= 0 || (arkElement = elements.get(0).getArkElement()) == null) {
            return;
        }
        String bytesData = arkElement.getBytesData();
        if (TextUtils.isEmpty(bytesData)) {
            return;
        }
        this.f254345d = new ArkAppContainer(false);
        a aVar = new a();
        aVar.o(bytesData);
        this.f254345d.h(aVar.d(), aVar.e(), "", aVar.c(), aVar.m(), ViewUtils.getDensity(), new SessionInfo());
        this.f254345d.setFixSize(ViewUtils.getScreenWidth() - ViewUtils.dip2px(32.0f), -1);
        this.f254346e.initArkView(this.f254345d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
    }
}
