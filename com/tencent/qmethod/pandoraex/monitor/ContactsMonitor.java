package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ContactsMonitor {
    private static final String CONTACT_URI = "content://com.android.contacts";
    private static final String TAG = "ContactsMonitor";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private interface ResultConverter {
        Object convert();
    }

    private static boolean isQueryMediaFiles(String str) {
        if (!str.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) && !str.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
            return false;
        }
        return true;
    }

    public static Cursor query(final ContentResolver contentResolver, @NonNull final Uri uri, final String[] strArr, final String str, final String[] strArr2, final String str2) throws Throwable {
        String uri2 = uri.toString();
        com.tencent.qmethod.pandoraex.core.k<Cursor> kVar = new com.tencent.qmethod.pandoraex.core.k<Cursor>() { // from class: com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Cursor call() {
                return contentResolver.query(uri, strArr, str, strArr2, str2);
            }
        };
        if (uri2.startsWith(CONTACT_URI)) {
            return (Cursor) a.C11438a.n(kVar).f("contact").c("CR#QUERY_CON#U[SS[SS").l("CR#QUERY_CON#U[SS[SS", "").e();
        }
        if (isQueryMediaFiles(uri2)) {
            return (Cursor) a.C11438a.n(kVar).f("mediaFile").c("CR#QUERY_CON#U[SS[SS").l("CR#QUERY", "").e();
        }
        if (SmsMonitor.isQuerySms(uri2)) {
            return (Cursor) a.C11438a.n(kVar).f("sms").c("CR#QUERY_CON#U[SS[SS").e();
        }
        if (OaidMonitor.isVivoOaid(uri2)) {
            return (Cursor) a.C11438a.p(new OaidMonitor.VivoOaidCall() { // from class: com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.tencent.qmethod.pandoraex.monitor.OaidMonitor.VivoOaidCall, com.tencent.qmethod.pandoraex.core.k
                public Cursor call() {
                    return contentResolver.query(uri, strArr, str, strArr2, str2);
                }
            }).f("device").c("OAID#VIVO").m(String.class).e();
        }
        RelationBootMonitor.inspectUri(12, uri);
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    @SuppressLint({"NewApi"})
    public static Cursor query(final ContentResolver contentResolver, final Uri uri, final String[] strArr, final String str, final String[] strArr2, final String str2, final CancellationSignal cancellationSignal) throws Throwable {
        String uri2 = uri.toString();
        com.tencent.qmethod.pandoraex.core.k<Cursor> kVar = new com.tencent.qmethod.pandoraex.core.k<Cursor>() { // from class: com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 16)
            public Cursor call() {
                return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            }
        };
        if (uri2.startsWith(CONTACT_URI)) {
            return (Cursor) a.C11438a.n(kVar).f("contact").c("CR#QUERY_CON#U[SS[SSC").l("CR#QUERY_CON#U[SS[SSC", "").e();
        }
        if (isQueryMediaFiles(uri2)) {
            return (Cursor) a.C11438a.o(kVar).f("mediaFile").c("CR#QUERY_CON#U[SS[SSC").l("CR#QUERY", "").e();
        }
        if (SmsMonitor.isQuerySms(uri2)) {
            return (Cursor) a.C11438a.o(kVar).f("sms").c("CR#QUERY_CON#U[SS[SSC").e();
        }
        if (OaidMonitor.isVivoOaid(uri2)) {
            return (Cursor) a.C11438a.p(new OaidMonitor.VivoOaidCall() { // from class: com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.tencent.qmethod.pandoraex.monitor.OaidMonitor.VivoOaidCall, com.tencent.qmethod.pandoraex.core.k
                public Cursor call() {
                    return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
                }
            }).f("device").c("OAID#VIVO").m(String.class).e();
        }
        RelationBootMonitor.inspectUri(12, uri);
        return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    @SuppressLint({"NewApi"})
    public static Cursor query(final ContentResolver contentResolver, final Uri uri, final String[] strArr, final Bundle bundle, final CancellationSignal cancellationSignal) throws Throwable {
        Cursor query;
        com.tencent.qmethod.pandoraex.core.k<Cursor> kVar = new com.tencent.qmethod.pandoraex.core.k<Cursor>() { // from class: com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Cursor call() {
                Cursor query2;
                query2 = contentResolver.query(uri, strArr, bundle, cancellationSignal);
                return query2;
            }
        };
        String uri2 = uri.toString();
        if (uri2.startsWith(CONTACT_URI)) {
            return (Cursor) a.C11438a.n(kVar).f("contact").c("CR#QUERY_CON#U[SBC").l("CR#QUERY_CON#U[SBC", "").e();
        }
        if (isQueryMediaFiles(uri2)) {
            return (Cursor) a.C11438a.n(kVar).f("mediaFile").c("CR#QUERY_CON#U[SBC").l("CR#QUERY", "").e();
        }
        if (SmsMonitor.isQuerySms(uri2)) {
            return (Cursor) a.C11438a.n(kVar).f("sms").c("CR#QUERY_CON#U[SBC").e();
        }
        if (OaidMonitor.isVivoOaid(uri2)) {
            return (Cursor) a.C11438a.p(new OaidMonitor.VivoOaidCall() { // from class: com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.tencent.qmethod.pandoraex.monitor.OaidMonitor.VivoOaidCall, com.tencent.qmethod.pandoraex.core.k
                public Cursor call() {
                    Cursor query2;
                    query2 = contentResolver.query(uri, strArr, bundle, cancellationSignal);
                    return query2;
                }
            }).f("device").c("OAID#VIVO").m(String.class).e();
        }
        RelationBootMonitor.inspectUri(12, uri);
        query = contentResolver.query(uri, strArr, bundle, cancellationSignal);
        return query;
    }
}
