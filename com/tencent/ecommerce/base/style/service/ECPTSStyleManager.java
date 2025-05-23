package com.tencent.ecommerce.base.style.service;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.ecommerce.base.style.api.IECPTSStyleManager;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.utils.PTSFileUtil;
import gh0.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ*\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0014j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012`\u00152\u0006\u0010\u0013\u001a\u00020\u0012R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/base/style/service/ECPTSStyleManager;", "Lcom/tencent/ecommerce/base/style/api/IECPTSStyleManager;", "", "pageName", "Landroid/content/Context;", "context", "e", "", "b", "frameTreeJson", IECSearchBar.METHOD_UPDATE_STYLE, "preloadStyle", "PAGE_NAME", "jsonData", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "listener", "Lcom/tencent/pts/core/PTSComposer;", "c", "", "viewTypeStart", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "fullPageNameList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECPTSStyleManager implements IECPTSStyleManager {

    /* renamed from: b, reason: collision with root package name */
    public static final ECPTSStyleManager f100993b = new ECPTSStyleManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<String> fullPageNameList = new CopyOnWriteArrayList<>();

    ECPTSStyleManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String pageName) {
        if (TextUtils.isEmpty(pageName)) {
            return;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = fullPageNameList;
        if (copyOnWriteArrayList.contains(pageName)) {
            return;
        }
        copyOnWriteArrayList.add(pageName);
    }

    @JvmStatic
    public static final String e(String pageName, Context context) {
        return PTSFileUtil.getFileContent(PTSFileUtil.getFilePath(pageName, "pts_styles", PTSFileUtil.FRAME_TREE_FORMAT), context, true);
    }

    public final PTSComposer c(String PAGE_NAME, String jsonData, IPTSLiteEventListener listener) {
        return d.f402041a.b(PAGE_NAME, e(PAGE_NAME, wg0.a.a()), jsonData, listener);
    }

    public final HashMap<String, Integer> d(int viewTypeStart) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Iterator it = new ArrayList(fullPageNameList).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                cg0.a.a("PTSStyleManager", "[createPageNameToViewTypeMap]", "pageName is null.");
            } else {
                cg0.a.b("PTSStyleManager", "[createPageNameToViewTypeMap] pageName = " + str + ", viewType = " + viewTypeStart);
                hashMap.put(str, Integer.valueOf(viewTypeStart));
                viewTypeStart++;
            }
        }
        return hashMap;
    }

    @Override // com.tencent.ecommerce.base.style.api.IECPTSStyleManager
    public void updateStyle(String pageName, String frameTreeJson) {
        if (!TextUtils.isEmpty(pageName) && !TextUtils.isEmpty(frameTreeJson)) {
            PTSFileUtil.updateFileContentCache(PTSFileUtil.getFilePath(pageName, "pts_styles", PTSFileUtil.FRAME_TREE_FORMAT), frameTreeJson);
            b(pageName);
        } else {
            cg0.a.b("PTSStyleManager", "[updateStyle], pageName or frameTreeJson is null");
        }
    }

    @Override // com.tencent.ecommerce.base.style.api.IECPTSStyleManager
    public void preloadStyle(final Context context) {
        if (context == null) {
            return;
        }
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.base.style.service.ECPTSStyleManager$preloadStyle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    String[] list = context.getAssets().list("pts_styles");
                    if (list != null) {
                        for (String str : list) {
                            PTSFileUtil.loadFile(PTSFileUtil.getFilePath(str, "pts_styles", PTSFileUtil.FRAME_TREE_FORMAT), context, true);
                            cg0.a.b("PTSStyleManager", "[preloadStyle], pageName = " + str);
                            ECPTSStyleManager.f100993b.b(str);
                        }
                    }
                } catch (Throwable th5) {
                    cg0.a.a("PTSStyleManager", "preloadStyle", "[preloadStyle] error, e = " + th5);
                }
            }
        });
    }
}
