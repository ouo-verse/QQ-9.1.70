package da0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.utils.JsonBinder;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d<T extends QCircleBaseWnsConfigResPackage> extends b implements QzoneConfig.QzoneConfigChangeListener {
    private final String H;
    private final String I;
    private final String J;

    public d(T t16) {
        super(t16);
        this.H = t16.getMainKey();
        this.I = t16.getResConfigKey();
        this.J = t16.getDiffTimeConfigKey();
    }

    private void u() {
        if (TextUtils.isEmpty(this.J)) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig(this.H, this.J, "");
        QLog.d(this.f393297d, 1, " initRes timeConfig is  " + config);
        y(config);
    }

    private boolean v() {
        if (TextUtils.isEmpty(this.I)) {
            return true;
        }
        String config = QzoneConfig.getInstance().getConfig(this.H, this.I, "");
        QLog.d(this.f393297d, 1, " initRes resConfig is  " + config);
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        return x(config);
    }

    @Override // da0.b
    public synchronized void h() {
        super.h();
        w();
    }

    @Override // da0.b
    public boolean n() {
        if (this.D == null) {
            w();
        }
        return super.n();
    }

    @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
    public void onConfigChange() {
        QLog.d(this.f393297d, 1, "QzoneConfig data change");
        w();
        QzoneConfig.getInstance().removeListener(this);
    }

    protected void t() {
        QLog.d(this.f393297d, 1, "addReloadConfigListener");
        QzoneConfig.getInstance().removeListener(this);
        QzoneConfig.getInstance().addListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        if (!v()) {
            t();
        } else {
            u();
        }
    }

    protected boolean x(String str) {
        try {
            r((QCircleBaseWnsConfigResPackage) JsonBinder.getInstance().fromJson(str, (Class) this.C.o().getClass()));
            return true;
        } catch (Exception e16) {
            QLog.e(this.f393297d, 1, "json config error :" + e16);
            return false;
        }
    }

    protected void y(String str) {
        String[] split = str.split(",");
        if (split.length != 2) {
            return;
        }
        try {
            s(Long.parseLong(split[0]), Long.parseLong(split[1]));
        } catch (Exception unused) {
            QLog.d(this.f393297d, 1, "parse time error,config is " + str);
        }
    }
}
