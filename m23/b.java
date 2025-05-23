package m23;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f416041a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, n23.a> f416042b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, QQValuePagView> f416043c = new HashMap();

    public static b b() {
        return f416041a;
    }

    public void a(String str, QQValuePagView qQValuePagView) {
        f416043c.put(str, qQValuePagView);
    }

    public n23.a c(@NonNull String str) {
        if (str == null) {
            return null;
        }
        Map<String, n23.a> map = f416042b;
        n23.a aVar = map.get(str);
        if (aVar != null) {
            return aVar;
        }
        n23.a b16 = n23.a.b(str);
        if (b16 != null) {
            map.put(str, b16);
        }
        return b16;
    }

    public String d(String str) {
        n23.a c16 = b().c(str);
        if (c16 != null && !TextUtils.isEmpty(c16.f418037d)) {
            return c16.f418037d;
        }
        return "";
    }

    public void e(String str, Object obj) {
        b().h(str, obj);
        i(str);
    }

    public void f(String str) {
        QQValueViewBusiness qQValueViewBusiness = (QQValueViewBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(QQValueViewBusiness.class);
        if (qQValueViewBusiness != null) {
            qQValueViewBusiness.addUpdateListener(new a(str));
            String d16 = d(str);
            if (!TextUtils.isEmpty(d16)) {
                qQValueViewBusiness.startDownload(d16);
            }
        }
    }

    public void g(String str) {
        f416043c.remove(str);
    }

    public void h(@NonNull String str, Object obj) {
        n23.a f16 = n23.a.f(obj);
        if (f16 != null && !f16.a(c(str))) {
            f416042b.put(str, f16);
            f16.g(str);
        }
    }

    public void i(String str) {
        for (QQValuePagView qQValuePagView : f416043c.values()) {
            if (qQValuePagView.isFocused()) {
                qQValuePagView.A(str, ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f416044a;

        a(String str) {
            this.f416044a = str;
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
            b.b().i(this.f416044a);
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onLoadFail(UpdateListenerParams updateListenerParams) {
        }

        @Override // com.tencent.vas.update.callback.listener.IUpdateListener
        public void onProgress(UpdateListenerParams updateListenerParams) {
        }
    }
}
