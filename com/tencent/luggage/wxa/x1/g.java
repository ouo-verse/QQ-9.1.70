package com.tencent.luggage.wxa.x1;

import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 463;
    private static final String NAME = "updateKeyboard";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f144540a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144541b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f144542c;

        public a(l lVar, String str, int i3) {
            this.f144540a = lVar;
            this.f144541b = str;
            this.f144542c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            v J;
            String str;
            if (this.f144540a.isRunning() && (J = this.f144540a.J()) != null) {
                com.tencent.luggage.wxa.f2.a d16 = com.tencent.luggage.wxa.f2.a.d(J.getContentView());
                if (d16 != null) {
                    WAGamePanelInputEditText attachedEditText = d16.getAttachedEditText();
                    int maxLength = attachedEditText.getMaxLength();
                    w.g("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", Integer.valueOf(maxLength));
                    if (!w0.c(this.f144541b)) {
                        if (maxLength > 0) {
                            if (this.f144541b.length() > maxLength) {
                                str = this.f144541b.substring(0, maxLength);
                            } else {
                                str = this.f144541b;
                            }
                            attachedEditText.setText(str);
                        } else {
                            attachedEditText.setText(this.f144541b);
                        }
                        attachedEditText.setSelection(attachedEditText.getText().length());
                    } else {
                        attachedEditText.setText("");
                    }
                    this.f144540a.a(this.f144542c, g.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                    return;
                }
                this.f144540a.a(this.f144542c, g.this.makeReturnJson("fail"));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        c0.a(new a(lVar, jSONObject.optString("value"), i3));
    }
}
