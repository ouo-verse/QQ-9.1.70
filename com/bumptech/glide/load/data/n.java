package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class n extends l<InputStream> {

    /* renamed from: h, reason: collision with root package name */
    private static final UriMatcher f31594h;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f31594h = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream g(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f31594h.match(uri);
        if (match != 1) {
            if (match != 3) {
                if (match != 5) {
                    return contentResolver.openInputStream(uri);
                }
            } else {
                return h(contentResolver, uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return h(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    private InputStream h(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.l
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.l
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InputStream d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream g16 = g(uri, contentResolver);
        if (g16 != null) {
            return g16;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }
}
