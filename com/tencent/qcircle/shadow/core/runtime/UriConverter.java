package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.DelegateProvider;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.DelegateProviderHolder;

/* compiled from: P */
/* loaded from: classes22.dex */
public class UriConverter {
    public static Uri build(Uri.Builder builder) {
        return parse(builder.build().toString());
    }

    public static Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        return contentResolver.call(parseCall(uri.toString(), bundle), str, str2, bundle);
    }

    public static void notifyChange(ContentResolver contentResolver, Uri uri, ContentObserver contentObserver) {
        contentResolver.notifyChange(parse(uri.toString()), contentObserver);
    }

    public static Uri parse(String str) {
        DelegateProvider delegateProviderFromUUid = DelegateProviderHolder.getDelegateProviderFromUUid("");
        if (delegateProviderFromUUid != null && delegateProviderFromUUid.getUriParseDelegate() != null) {
            return delegateProviderFromUUid.getUriParseDelegate().parse(str);
        }
        return Uri.parse(str);
    }

    public static Uri parseCall(String str, Bundle bundle) {
        DelegateProvider delegateProviderFromUUid = DelegateProviderHolder.getDelegateProviderFromUUid("");
        if (delegateProviderFromUUid != null && delegateProviderFromUUid.getUriParseDelegate() != null) {
            return delegateProviderFromUUid.getUriParseDelegate().parseCall(str, bundle);
        }
        return Uri.parse(str);
    }

    public static void notifyChange(ContentResolver contentResolver, Uri uri, ContentObserver contentObserver, boolean z16) {
        contentResolver.notifyChange(parse(uri.toString()), contentObserver, z16);
    }

    @TargetApi(26)
    public static void notifyChange(ContentResolver contentResolver, Uri uri, ContentObserver contentObserver, int i3) {
        contentResolver.notifyChange(parse(uri.toString()), contentObserver, i3);
    }
}
