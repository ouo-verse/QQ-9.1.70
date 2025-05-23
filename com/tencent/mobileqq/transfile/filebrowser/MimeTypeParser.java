package com.tencent.mobileqq.transfile.filebrowser;

import android.content.res.XmlResourceParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes19.dex */
public class MimeTypeParser {
    static IPatchRedirector $redirector_ = null;
    public static final String ATTR_EXTENSION = "extension";
    public static final String ATTR_MIMETYPE = "mimetype";
    private static final String LOG_TAG = "MimeTypeParser";
    public static final String TAG_MIMETYPES = "MimeTypes";
    public static final String TAG_TYPE = "type";
    private MimeTypes mMimeTypes;
    private XmlPullParser mXpp;

    public MimeTypeParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void addMimeTypeStart() {
        this.mMimeTypes.put(this.mXpp.getAttributeValue(null, ATTR_EXTENSION), this.mXpp.getAttributeValue(null, "mimetype"));
    }

    public MimeTypes fromXml(InputStream inputStream) throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MimeTypes) iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputStream);
        }
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        this.mXpp = newPullParser;
        newPullParser.setInput(new InputStreamReader(inputStream));
        return parse();
    }

    public MimeTypes fromXmlResource(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MimeTypes) iPatchRedirector.redirect((short) 3, (Object) this, (Object) xmlResourceParser);
        }
        this.mXpp = xmlResourceParser;
        return parse();
    }

    public MimeTypes parse() throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MimeTypes) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        this.mMimeTypes = new MimeTypes();
        int eventType = this.mXpp.getEventType();
        while (eventType != 1) {
            String name = this.mXpp.getName();
            if (eventType == 2) {
                if (!name.equals(TAG_MIMETYPES) && name.equals("type")) {
                    addMimeTypeStart();
                }
            } else if (eventType == 3) {
                name.equals(TAG_MIMETYPES);
            }
            eventType = this.mXpp.next();
        }
        return this.mMimeTypes;
    }
}
