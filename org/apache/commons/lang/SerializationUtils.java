package org.apache.commons.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SerializationUtils {
    public static Object clone(Serializable serializable) {
        return deserialize(serialize(serializable));
    }

    public static Object deserialize(InputStream inputStream) {
        if (inputStream != null) {
            ObjectInputStream objectInputStream = null;
            try {
                try {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(inputStream);
                    try {
                        Object readObject = objectInputStream2.readObject();
                        try {
                            objectInputStream2.close();
                        } catch (IOException unused) {
                        }
                        return readObject;
                    } catch (IOException e16) {
                        e = e16;
                        throw new SerializationException(e);
                    } catch (ClassNotFoundException e17) {
                        e = e17;
                        throw new SerializationException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        objectInputStream = objectInputStream2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e18) {
                    e = e18;
                } catch (ClassNotFoundException e19) {
                    e = e19;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            throw new IllegalArgumentException("The InputStream must not be null");
        }
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        if (outputStream != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(outputStream);
                    try {
                        objectOutputStream2.writeObject(serializable);
                        try {
                            objectOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        throw new SerializationException(e);
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } else {
            throw new IllegalArgumentException("The OutputStream must not be null");
        }
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Object deserialize(byte[] bArr) {
        if (bArr != null) {
            return deserialize(new ByteArrayInputStream(bArr));
        }
        throw new IllegalArgumentException("The byte[] must not be null");
    }
}
