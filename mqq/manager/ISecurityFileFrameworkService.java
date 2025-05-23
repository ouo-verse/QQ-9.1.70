package mqq.manager;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.io.File;
import mqq.app.ISecurityFileHelper;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes28.dex */
public interface ISecurityFileFrameworkService extends IRuntimeService {
    String getEncryptUIN();

    @Nullable
    File getUINRootFile(@Nullable ISecurityFileHelper iSecurityFileHelper);
}
