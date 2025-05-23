package d15;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qphone.base.util.QLog;
import e15.f;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f392669a;

    /* renamed from: b, reason: collision with root package name */
    private f15.a f392670b;

    a(Context context) {
        this.f392669a = new WeakReference<>(context);
    }

    private final f a(String str, Context context, JSONObject jSONObject) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("JsonInflater", 2, "createViewModel\uff1a" + str);
                }
                View b16 = this.f392670b.b(context, str);
                if (b16 == null) {
                    return null;
                }
                f c16 = this.f392670b.c(str, b16);
                j(c16, jSONObject);
                return c16;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("JsonInflater", 1, "Error inflating type : " + str);
                if (QLog.isColorLevel()) {
                    QLog.i("JsonInflater", 2, "createViewModel fail finish");
                }
            }
        }
        return null;
    }

    public static a b(@NonNull Context context) {
        return new a(context);
    }

    private ViewGroup.LayoutParams c(View view, f fVar, JSONObject jSONObject) {
        if (view != null && jSONObject != null && jSONObject.length() != 0 && fVar != null) {
            return this.f392670b.a(view).c(jSONObject, fVar);
        }
        return null;
    }

    private f h(JSONObject jSONObject, ViewGroup viewGroup, boolean z16) {
        boolean z17;
        ViewGroup.LayoutParams layoutParams;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.i("JsonInflater", 2, "inflate: ");
            }
            WeakReference<Context> weakReference = this.f392669a;
            if (weakReference != null && weakReference.get() != null) {
                Context context = this.f392669a.get();
                if (context == null) {
                    return null;
                }
                String optString = jSONObject.optString("type");
                if (QLog.isColorLevel()) {
                    QLog.i("JsonInflater", 2, "Creating root view:");
                }
                f a16 = a(optString, context, jSONObject);
                if (a16 == null) {
                    QLog.e("JsonInflater", 1, "inflate: createViewModel error null return");
                    return null;
                }
                View i3 = a16.i();
                if (i3 == null) {
                    QLog.e("JsonInflater", 1, "inflate: tempView error null return");
                    return null;
                }
                if (viewGroup != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("JsonInflater", 2, "generateLayoutParams");
                    }
                    layoutParams = c(viewGroup, a16, jSONObject);
                    if (!z16 && layoutParams != null) {
                        i3.setLayoutParams(layoutParams);
                    }
                } else {
                    layoutParams = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("JsonInflater", 2, "-----> start inflating children");
                }
                i(a16, i3.getContext(), jSONObject);
                if (QLog.isColorLevel()) {
                    QLog.i("JsonInflater", 2, "-----> done inflating children");
                }
                if (viewGroup != null && z16) {
                    viewGroup.addView(i3, layoutParams);
                    a16.p();
                }
                return a16;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("inflate: weakContext == null \uff1a ");
            if (this.f392669a == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append(" || weakContext.get() == null ");
            QLog.e("JsonInflater", 1, sb5.toString());
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("JsonInflater", 1, "inflate: exception");
            return null;
        }
    }

    public f d(String str, ViewGroup viewGroup, boolean z16, f15.a aVar) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            return f(jSONObject, viewGroup, z16, aVar);
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e17) {
            e17.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        return e(jSONArray, viewGroup, z16, aVar);
    }

    public f e(@NonNull JSONArray jSONArray, ViewGroup viewGroup, boolean z16, f15.a aVar) {
        this.f392670b = aVar;
        WeakReference<Context> weakReference = this.f392669a;
        boolean z17 = false;
        if (weakReference != null && weakReference.get() != null) {
            Context context = this.f392669a.get();
            if (context == null) {
                return null;
            }
            RelativeLayout relativeLayout = new RelativeLayout(context);
            f a16 = this.f392670b.a(relativeLayout);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                f h16 = h(jSONArray.optJSONObject(i3), relativeLayout, false);
                if (h16 != null) {
                    relativeLayout.addView(h16.i());
                    h16.p();
                    a16.a(h16);
                }
            }
            return a16;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("inflate: weakContext == null \uff1a ");
        if (this.f392669a == null) {
            z17 = true;
        }
        sb5.append(z17);
        sb5.append(" || weakContext.get() == null ");
        QLog.e("JsonInflater", 1, sb5.toString());
        return null;
    }

    public f f(@NonNull JSONObject jSONObject, ViewGroup viewGroup, boolean z16, f15.a aVar) {
        AssertUtils.mainThreadCheck();
        this.f392670b = aVar;
        return h(jSONObject, viewGroup, z16);
    }

    public f g(String str, f15.a aVar) {
        return d(str, null, true, aVar);
    }

    void i(f fVar, Context context, JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (fVar == null || context == null || jSONObject == null || jSONObject.length() == 0 || (optJSONArray = jSONObject.optJSONArray("child")) == null) {
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                f a16 = a(optJSONObject.optString("type"), context, optJSONObject);
                ViewGroup viewGroup = (ViewGroup) fVar.i();
                ViewGroup.LayoutParams c16 = c(viewGroup, a16, optJSONObject);
                i(a16, context, optJSONObject);
                if (a16 != null && a16.i() != null) {
                    viewGroup.addView(a16.i(), c16);
                    a16.p();
                    fVar.a(a16);
                }
            } else {
                QLog.e("JsonInflater", 1, "rInflateChildren error: object = null");
            }
        }
    }

    protected void j(f fVar, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            if (fVar != null) {
                fVar.r(jSONObject);
            }
            this.f392670b.d(fVar, jSONObject);
        }
    }
}
